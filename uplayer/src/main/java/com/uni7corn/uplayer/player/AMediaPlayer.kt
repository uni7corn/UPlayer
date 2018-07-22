package com.uni7corn.uplayer.player

import android.content.Context
import android.view.Surface
import android.view.SurfaceHolder
import com.aliyun.vodplayer.media.AliyunVodPlayer
import com.aliyun.vodplayer.media.IAliyunVodPlayer
import com.uni7corn.uplayer.base.BaseMediaPlayer
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
 * desc:  aliyun 多媒体播放器
 */
class AMediaPlayer constructor(context: Context) : BaseMediaPlayer(), IAliyunVodPlayer.OnPreparedListener, IAliyunVodPlayer.OnFirstFrameStartListener, IAliyunVodPlayer.OnErrorListener {

    override fun create(context: Context): IMediaPlayer {
        return AMediaPlayer(context)
    }

    override fun onFirstFrameStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(p0: Int, p1: Int, p2: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPrepared() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSurface(surface: Surface) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val mMediaPlayer: AliyunVodPlayer by lazy {

        val aliyunVodPlayer = AliyunVodPlayer(context)

        aliyunVodPlayer.enableNativeLog()

        aliyunVodPlayer.setOnPreparedListener(this)
        aliyunVodPlayer.setOnFirstFrameStartListener(this)
        aliyunVodPlayer.setOnErrorListener(this)
        //aliyunVodPlayer.setOnCompletionListener(this)
        // aliyunVodPlayer.setOnSeekCompleteListener(this)
        //aliyunVodPlayer.setOnStoppedListner(this)
        // aliyunVodPlayer.setOnChangeQualityListener(this)
        // aliyunVodPlayer.setOnUrlTimeExpiredListener(this)

        return@lazy aliyunVodPlayer
    }

    override fun setDisplay(surfaceHolder: SurfaceHolder) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun serSourceData(sourceData: BaseSourceData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun prepareAsync() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun prepare() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun play(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playSeekTo(durationPosition: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playPre() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playNext() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun rePlay() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun seekTo(duration: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reset() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun release() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlayerStatus(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPlaying(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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