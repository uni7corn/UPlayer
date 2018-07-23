package com.uni7corn.uplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.SeekBar
import com.uni7corn.uplayer.R
import kotlinx.android.synthetic.main.lay_video_controller_view.view.*
import java.util.*

/**
 * Created by dq
 *
 * on 2018/7/17
 *
 * desc: CBTI  视频播放器控制器
 */
class VideoController : LinearLayout, View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private var onControllerCallback: OnControllerCallback? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    private fun initView(context: Context) {
        View.inflate(context, R.layout.lay_video_controller_view, this)

        iv_player_status.setOnClickListener(this)
        sb_progress.setOnSeekBarChangeListener(this)
        iv_scale.setOnClickListener(this)
    }

    fun setOnControllerCallback(onControllerCallback: OnControllerCallback) {
        this.onControllerCallback = onControllerCallback
    }

    fun updateDuration(currentPosition: Int, duration: Int) {
        val currentMin = currentPosition / 60
        val currentSecond = currentPosition % 60

        val min = duration / 60
        val second = duration % 60
        if (duration >= 60 * 60) {
            val currentHour = currentPosition / 3600
            val hour = duration / 3600
            tv_duration.text = String.format(Locale.getDefault(), "%02d:%02d:%02d/%02d:%02d:%02d", currentHour, currentMin, currentSecond, hour, min, second)
        } else {
            tv_duration.text = String.format(Locale.getDefault(), "%02d:%02d/%02d:%02d", currentMin, currentSecond, min, second)
        }

        val progress = duration / 100 * currentPosition

        sb_progress.progress = progress
    }

    fun setEnterFullScreen(isEnterFullScreen: Boolean) {
        if (isEnterFullScreen) {
            tv_lesson_list.visibility = View.VISIBLE
            iv_scale.visibility = View.GONE
        } else {
            iv_scale.visibility = View.VISIBLE
            tv_lesson_list.visibility = View.GONE
        }
    }

    fun setPlaying(isPlaying: Boolean) {
        if (isPlaying) {
            updatePlaying(iv_player_status)
        } else {
            updatePause(iv_player_status)
        }
    }

    fun show() {
        visibility = View.VISIBLE
    }

    fun hide() {
        visibility = View.GONE
    }

    fun autoDissmiss() {
        postDelayed({
            hide()
        }, 2000)
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {
        onControllerCallback?.pause()
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {
        onControllerCallback?.play()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.iv_player_status -> {
                if (v.tag == null) {
                    updatePlaying(v)
                    onControllerCallback?.play()
                } else {
                    updatePause(v)
                    onControllerCallback?.pause()
                }
            }
            R.id.tv_lesson_list -> {
                onControllerCallback?.showExtraContent()
            }
            R.id.iv_scale -> {//点击进入全屏
                onControllerCallback?.enterFullScreen()
                setEnterFullScreen(true)
            }
        }
        //autoDissmiss()
    }

    private fun updatePause(v: View) {
        v.tag = null
        iv_player_status.setImageResource(R.drawable.ic_cbti_icon_play_s)
    }

    private fun updatePlaying(v: View) {
        v.tag = true
        iv_player_status.setImageResource(R.drawable.ic_cbti_icon_pause_s)
    }

    interface OnControllerCallback {

        /**
         * 显示额外的窗口内容
         */
        fun showExtraContent()

        /**
         * 播放
         */
        fun play()

        /**
         * 暂停
         */
        fun pause()

        /**
         * 进入全屏
         */
        fun enterFullScreen()

        /**
         * 退出全屏
         */
        fun exitFullScreen(): Boolean

    }
}