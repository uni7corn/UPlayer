package com.uni7corn.uplayer.player

import android.content.Context
import android.media.MediaPlayer
import android.view.Surface
import android.view.SurfaceHolder
import com.uni7corn.uplayer.base.BaseMediaPlayer
import com.uni7corn.uplayer.base.BaseSourceData
import com.uni7corn.uplayer.event.OnCompletionEvent
import com.uni7corn.uplayer.event.OnErrorEvent
import com.uni7corn.uplayer.event.OnPreparedEvent
import com.uni7corn.uplayer.event.OnSeekCompleteEvent

/**
 * Created by dq
 *
 * on 2018/7/23
 *
 * desc:native media player
 */
class NativeMediaPlayer constructor(context: Context) : BaseMediaPlayer(), MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener {

    private val mediaPlayer: MediaPlayer by lazy {

        val mediaPlayer = MediaPlayer()

        mediaPlayer.setOnPreparedListener(this)
        mediaPlayer.setOnSeekCompleteListener(this)
        mediaPlayer.setOnBufferingUpdateListener(this)
        mediaPlayer.setOnErrorListener(this)

        return@lazy mediaPlayer
    }

    override fun create(context: Context): IMediaPlayer {
        return NativeMediaPlayer(context)
    }

    override fun start() {
        mediaPlayer.start()
    }

    override fun serSourceData(sourceData: BaseSourceData) {
        mediaPlayer.setDataSource(sourceData.url)
    }

    override fun onError(mp: MediaPlayer, what: Int, extra: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBufferingUpdate(mp: MediaPlayer, percent: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPrepared(mp: MediaPlayer) {
        start()
    }

    override fun onSeekComplete(mp: MediaPlayer) {
        start()
    }

    override fun setDisplay(surfaceHolder: SurfaceHolder) {
        mediaPlayer.setDisplay(surfaceHolder)
    }

    override fun setSurface(surface: Surface) {
        mediaPlayer.setSurface(surface)
    }

    override fun rePlay() {
        mediaPlayer.start()
    }

    override fun resume() {
        if (isPlaying()) {
            pause()
        } else {
            start()
        }
    }

    override fun prepare() {
        super.prepare()
        mediaPlayer.prepare()
    }

    override fun prepareAsync() {
        super.prepareAsync()
        mediaPlayer.prepareAsync()
    }

    override fun seekTo(duration: Int) {
        mediaPlayer.seekTo(duration)
    }

    override fun getTotalDuration(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentPlayPosition(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setVolume(volume: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVolume(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAutoPlay(isAutoPlay: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVideoWidth(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVideoHeight(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOnCompletionEvent(onCompletionEvent: OnCompletionEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOnErrorEvent(onErrorEvent: OnErrorEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOnPreparedEvent(onPreparedEvent: OnPreparedEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOnSeekCompleteEvent(onSeekCompleteEvent: OnSeekCompleteEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}