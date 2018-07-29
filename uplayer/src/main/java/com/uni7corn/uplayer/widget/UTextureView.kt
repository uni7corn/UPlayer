package com.uni7corn.uplayer.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.TextureView

/**
 * Created by dq
 *
 * on 2018/7/28
 *
 * desc:
 */
class UTextureView : TextureView {

    private var mOnTextureViewCallback: OnTextureViewCallback? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setOnTextureViewCallback(onTextureViewCallback: OnTextureViewCallback) {
        this.mOnTextureViewCallback = onTextureViewCallback
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                this.mOnTextureViewCallback?.showController()
            }
            MotionEvent.ACTION_CANCEL,
            MotionEvent.ACTION_UP -> {
                mOnTextureViewCallback?.dismissController()
            }
        }

        return true
    }

    interface OnTextureViewCallback {

        fun showController()

        fun dismissController()
    }
}