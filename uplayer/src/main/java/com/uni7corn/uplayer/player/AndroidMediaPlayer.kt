package com.uni7corn.uplayer.player

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioAttributes.CONTENT_TYPE_MUSIC
import android.media.AudioManager
import android.media.MediaPlayer
import android.view.Surface
import android.view.SurfaceHolder
import com.uni7corn.uplayer.adapter.AndroidMediaAdapter
import com.uni7corn.uplayer.base.BaseMediaPlayer
import com.uni7corn.uplayer.base.BaseSourceData
import com.uni7corn.uplayer.constant.MediaPlayStatus

/**
 * Created by dq
 *
 * on 2018/7/23
 *
 * desc:android native media player
 */
class AndroidMediaPlayer constructor(context: Context) : BaseMediaPlayer() {

    private var mContext: Context = context

    private var mSourceData: BaseSourceData? = null

    private val mAndroidMediaAdapter: AndroidMediaAdapter by lazy {
        AndroidMediaAdapter(this@AndroidMediaPlayer)
    }

    private val mediaPlayer: MediaPlayer by lazy {
        val mediaPlayer = MediaPlayer()
        mediaPlayer.isLooping = true
        mediaPlayer.setAudioAttributes(AudioAttributes.Builder().setContentType(CONTENT_TYPE_MUSIC).build())
        attachMediaListeners(mediaPlayer)
        return@lazy mediaPlayer
    }

    private fun attachMediaListeners(mediaPlayer: MediaPlayer) {
        mediaPlayer.setOnInfoListener(mAndroidMediaAdapter)
        mediaPlayer.setOnPreparedListener(mAndroidMediaAdapter)
        mediaPlayer.setOnBufferingUpdateListener(mAndroidMediaAdapter)
        mediaPlayer.setOnErrorListener(mAndroidMediaAdapter)
        mediaPlayer.setOnSeekCompleteListener(mAndroidMediaAdapter)
        mediaPlayer.setOnCompletionListener(mAndroidMediaAdapter)
        mediaPlayer.setOnTimedTextListener(mAndroidMediaAdapter)
    }

    override fun create(context: Context): IMediaPlayer {
        return AndroidMediaPlayer(context)
    }

    override fun setDisplay(surfaceHolder: SurfaceHolder) {
        mediaPlayer.setDisplay(surfaceHolder)
    }

    override fun setSurface(surface: Surface) {
        mediaPlayer.setSurface(surface)
    }

    override fun setSourceData(sourceData: BaseSourceData) {
        this.mSourceData = sourceData
        mediaPlayer.setDataSource(mSourceData?.url)
    }

    override fun prepareAsync() {
        this.mPlayStatus = MediaPlayStatus.PLAY_STATUS_PREPARE
        mediaPlayer.prepareAsync()
    }

    override fun prepare() {
        this.mPlayStatus = MediaPlayStatus.PLAY_STATUS_PREPARE
        mediaPlayer.prepare()
    }

    override fun play() {
        if (isPlaying() && mPlayStatus == MediaPlayStatus.PLAY_STATUS_PLAYING) {
            pause()
        } else {
            when (mPlayStatus) {
                MediaPlayStatus.PLAY_STATUS_PAUSE,
                MediaPlayStatus.PLAY_STATUS_STOP,
                MediaPlayStatus.PLAY_STATUS_COMPLETE -> {
                    start()
                }
                else -> {
                    reset()
                    setSourceData(mSourceData!!)
                    prepareAsync()
                }
            }
        }
    }

    override fun play(position: Int) {
        this.mCurrentPosition = position
        play()
    }

    override fun playPre() {
        play(mCurrentPosition--)
    }

    override fun playNext() {
        play(mCurrentPosition++)
    }

    override fun rePlay() {
        if (isPlaying()) {
            pause()
        } else {
            when (mPlayStatus) {
                MediaPlayStatus.PLAY_STATUS_COMPLETE -> {
                    start()
                }
                else -> {
                    play()
                }
            }

        }
    }

    override fun resume() {
        if (isPlaying()) {
            pause()
        } else {
            start()
        }
    }

    override fun start() {
        mPlayStatus = MediaPlayStatus.PLAY_STATUS_PLAYING
        mediaPlayer.start()
    }

    override fun pause() {
        mPlayStatus = MediaPlayStatus.PLAY_STATUS_PAUSE
        mediaPlayer.pause()
    }

    override fun stop() {
        mPlayStatus = MediaPlayStatus.PLAY_STATUS_STOP
        mediaPlayer.stop()
    }

    override fun seekTo(duration: Int) {
        mediaPlayer.seekTo(duration)
    }

    override fun reset() {
        mPlayStatus = MediaPlayStatus.PLAY_STATUS_IDLE
        mediaPlayer.reset()
    }

    override fun release() {
        mPlayStatus = MediaPlayStatus.PLAY_STATUS_IDLE
        mediaPlayer.release()
    }

    override fun getPlayerStatus(): Int {
        return mPlayStatus
    }

    override fun isPlaying(): Boolean {
        if (mediaPlayer.isPlaying) {
            if (mPlayStatus != MediaPlayStatus.PLAY_STATUS_PLAYING) {
                this.mPlayStatus = MediaPlayStatus.PLAY_STATUS_PLAYING
            }
            return true
        }
        return false
    }

    override fun isLooping(): Boolean {
        return mediaPlayer.isLooping
    }

    override fun getTotalDuration(): Int {
        return mediaPlayer.duration
    }

    override fun getCurrentPlayPosition(): Int {
        return mediaPlayer.currentPosition
    }

    override fun setVolume(volume: Float) {
        mediaPlayer.setVolume(volume, volume)
    }

    override fun getVolume(): Int {
        return (mContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager).getStreamMaxVolume(AudioManager.STREAM_MUSIC)
    }

    override fun setAutoPlay(isAutoPlay: Boolean) {
        this.mIsAutoPlay = isAutoPlay
    }

    override fun getVideoWidth(): Int {
        return this.mediaPlayer.videoWidth
    }

    override fun getVideoHeight(): Int {
        return this.mediaPlayer.videoHeight
    }
}