package com.uni7corn.uplayer.base

import android.media.TimedText
import com.uni7corn.uplayer.constant.MediaPlayStatus.PLAY_STATUS_IDLE
import com.uni7corn.uplayer.listener.OnIMediaPlayerListener
import com.uni7corn.uplayer.player.IMediaPlayer

/**
 * Created by sm
 *
 * on 2018/7/20
 *
 * desc:
 *
 */
abstract class BaseMediaPlayer : IMediaPlayer {

    protected var mCurrentPosition: Int = 0

    protected var mPlayStatus: Int = PLAY_STATUS_IDLE

    protected var mIsAutoPlay: Boolean = false

    private var mOnIMediaPlayerListener: OnIMediaPlayerListener? = null

    override fun setOnIMediaPlayerListener(onIMediaPlayerListener: OnIMediaPlayerListener) {
        this.mOnIMediaPlayerListener = onIMediaPlayerListener
    }

    fun notifyOnPrepared() {
        this.mOnIMediaPlayerListener?.onPrepared(this)
    }

    fun notifyOnError(what: Int, extra: Int): Boolean {
        return this.mOnIMediaPlayerListener?.onError(this, what, extra)!!
    }

    fun notifySeekComplete() {
        this.mOnIMediaPlayerListener?.onSeekComplete(this)
    }

    fun notifyOnCompletion() {
        this.mOnIMediaPlayerListener?.onCompletion(this)
    }

    fun notifyOnBufferingUpdate(percent: Int) {
        this.mOnIMediaPlayerListener?.onBufferingUpdate(this, percent)
    }

    fun notifyOnInfo(what: Int, extra: Int): Boolean {
        return this.mOnIMediaPlayerListener?.onInfo(this, what, extra)!!
    }

    fun notifyOnTimedText(text: TimedText?) {
        this.mOnIMediaPlayerListener?.onTimedText(this, text)
    }

}