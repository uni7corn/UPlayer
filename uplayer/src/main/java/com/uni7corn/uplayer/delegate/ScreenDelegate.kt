package com.uni7corn.uplayer.delegate

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.*
import android.widget.FrameLayout
import java.lang.ref.WeakReference

/**
 * Created by dq
 *
 * on 2018/7/23
 *
 * desc:
 */
class ScreenDelegate {

    companion object {

        private const val MODE_NORMAL_SCREEN = 0x11 //普通模式(default)
        private const val MODE_FULL_SCREEN = 0x12   //全屏模式
        private const val MODE_TINY_SCREEN = 0x13   //小窗口模式

    }

    private var mScreenMode = MODE_NORMAL_SCREEN

    private lateinit var mWeakActivityReference: WeakReference<AppCompatActivity>


    fun setUp(activity: AppCompatActivity): ScreenDelegate {
        this.mWeakActivityReference = WeakReference(activity)
        return this
    }

    @SuppressLint("RestrictedApi")
    fun enterFullScreen(child: ViewGroup) {
        if (mScreenMode == MODE_FULL_SCREEN) return

        if (child.parent != null) {
            (child.parent as ViewGroup).removeViewInLayout(child)
        }

        this.mWeakActivityReference.get()?.let {

            it.supportActionBar?.let {
                it.hide()
                it.setShowHideAnimationEnabled(true)
            }

            it.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

            it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE  //强制横屏
            //it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR //强制横屏由传感器触发,那么今后传感器会触发屏幕旋转

            val contentView: ViewGroup = it.findViewById(Window.ID_ANDROID_CONTENT)

            contentView.removeAllViewsInLayout()

            val params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

            contentView.addView(child, params)

            mScreenMode = MODE_FULL_SCREEN
        }
    }

    fun exitFullScreen(child: View) {

        if (mScreenMode == MODE_NORMAL_SCREEN) return

        if (mScreenMode == MODE_FULL_SCREEN) {

            this.mWeakActivityReference.get()?.let {

                it.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                val contentView = it.findViewById(android.R.id.content) as ViewGroup

                contentView.removeView(child)

                val params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                contentView.addView(child, params)

                mScreenMode = MODE_NORMAL_SCREEN
            }
        }

    }

    @SuppressLint("RtlHardcoded")
    fun enterTinyWindow(child: View) {

        if (mScreenMode == MODE_TINY_SCREEN) return

        if (child.parent != null) {
            (child.parent as ViewGroup).removeViewInLayout(child)
        }

        this.mWeakActivityReference.get()?.let {

            val contentView: ViewGroup = it.findViewById(android.R.id.content) as ViewGroup

            // 小窗口的宽度为屏幕宽度的60%，长宽比默认为16:9，右边距、下边距为8dp。
            val params = FrameLayout.LayoutParams((child.resources.displayMetrics.widthPixels * 0.6f).toInt(),
                    (child.resources.displayMetrics.heightPixels * 0.6f * 9f / 16f).toInt())

            params.gravity = Gravity.TOP or Gravity.RIGHT

            params.rightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f,
                    child.resources.displayMetrics).toInt()

            params.bottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f,
                    child.resources.displayMetrics).toInt()

            contentView.addView(child, params)

            mScreenMode = MODE_TINY_SCREEN
        }
    }

    fun getScreenMode(): Int {
        return mScreenMode
    }
}