package com.uni7corn.uplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Created by dq
 *
 * on 2018/7/17
 *
 * desc:  video  视频状态view  1.buffering loading  2.finished/error tips (缓冲loading  播放完成/播放错误 tips)
 */
class VideoStatusView : FrameLayout {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    private fun initView(context: Context) {

    }
}