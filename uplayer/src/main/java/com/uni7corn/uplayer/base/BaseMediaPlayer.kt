package com.uni7corn.uplayer.base

import com.uni7corn.uplayer.player.IMediaPlayer
import com.uni7corn.uplayer.player.IMediaPlayer.Companion.PLAY_STATUS_IDLE
import com.uni7corn.uplayer.player.IMediaPlayer.Companion.PLAY_STATUS_PAUSE
import com.uni7corn.uplayer.player.IMediaPlayer.Companion.PLAY_STATUS_PLAYING
import com.uni7corn.uplayer.player.IMediaPlayer.Companion.PLAY_STATUS_PREPARE
import com.uni7corn.uplayer.player.IMediaPlayer.Companion.PLAY_STATUS_STOP

/**
 * Created by sm
 *
 * on 2018/7/20
 *
 * desc:
 *
 */
abstract class BaseMediaPlayer : IMediaPlayer {

    override fun serSourceData(url: String) {

    }

    override fun prepareAsync() {
        this.mPlayStatus = PLAY_STATUS_PREPARE

    }

    override fun prepare() {
        this.mPlayStatus = PLAY_STATUS_PREPARE

    }

    override fun play() {
        this.mPlayStatus = PLAY_STATUS_PLAYING

    }

    override fun play(position: Int) {
        this.mCurrentPosition = position
        this.mPlayStatus = PLAY_STATUS_PLAYING

    }

    override fun playSeekTo(durationPosition: Int) {
        seekTo(durationPosition)
        prepareAsync()
    }

    override fun playNext() {
        this.mCurrentPosition++
        play(mCurrentPosition)

    }

    override fun playPre() {
        this.mCurrentPosition--
        play(mCurrentPosition)
    }

    override fun pause() {
        mPlayStatus = PLAY_STATUS_PAUSE

    }

    override fun stop() {
        mPlayStatus = PLAY_STATUS_STOP


    }

    override fun reset() {
        mPlayStatus = PLAY_STATUS_IDLE

    }

    override fun release() {
        stop()
        reset()
        mPlayStatus = PLAY_STATUS_IDLE
    }

    override fun getPlayerStatus(): Int {
        return mPlayStatus
    }

    override fun isPlaying(): Boolean {
        return mPlayStatus == PLAY_STATUS_PLAYING
    }
}