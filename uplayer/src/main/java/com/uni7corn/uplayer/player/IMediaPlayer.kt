package com.uni7corn.uplayer.player

import android.content.Context
import android.view.Surface
import android.view.SurfaceHolder
import com.uni7corn.uplayer.base.BaseSourceData
import com.uni7corn.uplayer.event.OnCompletionEvent
import com.uni7corn.uplayer.event.OnErrorEvent
import com.uni7corn.uplayer.event.OnPreparedEvent
import com.uni7corn.uplayer.event.OnSeekCompleteEvent

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

    fun serSourceData(sourceData: BaseSourceData)

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

    fun setOnCompletionEvent(onCompletionEvent: OnCompletionEvent)

    fun setOnErrorEvent(onErrorEvent: OnErrorEvent)

    fun setOnPreparedEvent(onPreparedEvent: OnPreparedEvent)

    fun setOnSeekCompleteEvent(onSeekCompleteEvent: OnSeekCompleteEvent)


}