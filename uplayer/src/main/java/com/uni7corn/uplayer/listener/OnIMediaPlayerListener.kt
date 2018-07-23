package com.uni7corn.uplayer.listener

import android.media.TimedText
import com.uni7corn.uplayer.player.IMediaPlayer

/**
 * Created by sm
 *
 * on 2018/7/23
 *
 * desc:
 *
 */
interface OnIMediaPlayerListener {

    fun onPrepared(iMediaPlayer: IMediaPlayer)

    fun onBufferingUpdate(iMediaPlayer: IMediaPlayer, percent: Int)

    fun onSeekComplete(iMediaPlayer: IMediaPlayer)

    fun onCompletion(iMediaPlayer: IMediaPlayer)

    fun onError(iMediaPlayer: IMediaPlayer, what: Int, extra: Int): Boolean

    fun onInfo(iMediaPlayer: IMediaPlayer, what: Int, extra: Int): Boolean

    fun onTimedText(iMediaPlayer: IMediaPlayer, text: TimedText?)

    fun onVideoSizeChanged(iMediaPlayer: IMediaPlayer, width: Int, height: Int)

}