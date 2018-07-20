package com.uni7corn.uplayer.player

import android.view.Surface
import android.view.SurfaceHolder

/**
 * Created by dq
 *
 * on 2018/7/18
 *
 * desc:
 */
interface IMediaPlayer {

    companion object {

        const val PLAY_STATUS_IDLE = 0x00

        const val PLAY_STATUS_PREPARE = 0x01
        const val PLAY_STATUS_PLAYING = 0x02
        const val PLAY_STATUS_PAUSE = 0x03
        const val PLAY_STATUS_STOP = 0x04
        const val PLAY_STATUS_COMPLETE = 0x05

        const val PLAY_STATUS_ERROR = 0xff

    }

    var mCurrentPosition: Int

    var mPlayStatus: Int

    var mIsAutoPlay: Boolean

    fun setDisplay(surfaceHolder: SurfaceHolder)

    fun setSurface(surface: Surface)

    fun serSourceData(url: String)

    fun prepareAsync()

    fun prepare()

    fun play()

    fun play(position: Int)

    fun playSeekTo(durationPosition: Int)

    fun playPre()

    fun playNext()

    fun rePlay()

    fun resume()

    fun pause()

    fun stop()

    fun seekTo(duration: Int)

    fun reset()

    fun release()

    fun getPlayerStatus(): Int

    fun isPlaying(): Boolean

    fun getTotalDuration(): Long

    fun getCurrentPlayPosition(): Long

    fun setVolume(volume: Int)

    fun getVolume(): Int

    fun setAutoPlay(isAutoPlay: Boolean = false)

    fun getVideoWidth(): Int

    fun getVideoHeight(): Int


}