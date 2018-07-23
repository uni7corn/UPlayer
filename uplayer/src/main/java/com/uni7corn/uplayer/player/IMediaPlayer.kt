package com.uni7corn.uplayer.player

import android.content.Context
import android.view.Surface
import android.view.SurfaceHolder
import com.uni7corn.uplayer.base.BaseSourceData
import com.uni7corn.uplayer.listener.OnIMediaPlayerListener

/**
 * Created by dq
 *
 * on 2018/7/18
 *
 * desc:
 */
interface IMediaPlayer {

    fun create(context: Context): IMediaPlayer

    fun setDisplay(surfaceHolder: SurfaceHolder)

    fun setSurface(surface: Surface)

    fun setSourceData(sourceData: BaseSourceData)

    fun prepareAsync()

    fun prepare()

    fun play()

    fun play(position: Int)

    fun playPre()

    fun playNext()

    fun rePlay()

    fun resume()

    fun start()

    fun pause()

    fun stop()

    fun seekTo(duration: Int)

    fun reset()

    fun release()

    fun getPlayerStatus(): Int

    fun isPlaying(): Boolean

    fun isLooping(): Boolean

    fun getTotalDuration(): Int

    fun getCurrentPlayPosition(): Int

    fun setVolume(volume: Float)

    fun getVolume(): Int

    fun setAutoPlay(isAutoPlay: Boolean = false)

    fun getVideoWidth(): Int

    fun getVideoHeight(): Int

    fun setOnIMediaPlayerListener(onIMediaPlayerListener: OnIMediaPlayerListener)


}