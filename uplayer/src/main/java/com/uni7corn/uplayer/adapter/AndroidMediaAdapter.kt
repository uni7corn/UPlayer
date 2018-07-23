package com.uni7corn.uplayer.adapter

import android.media.MediaPlayer
import android.media.TimedText
import com.uni7corn.uplayer.base.BaseMediaPlayer
import com.uni7corn.uplayer.player.IMediaPlayer
import java.lang.ref.WeakReference

/**
 * Created by sm
 *
 * on 2018/7/23
 *
 * desc: android native media player listener's adapter
 *
 */
class AndroidMediaAdapter constructor(iMediaPlayer: IMediaPlayer) :
        MediaPlayer.OnSeekCompleteListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnInfoListener,
        MediaPlayer.OnTimedTextListener {

    private val mWeakReference: WeakReference<IMediaPlayer> = WeakReference(iMediaPlayer)

    override fun onSeekComplete(mp: MediaPlayer) {
        getBaseMediaPlayer().notifySeekComplete()
    }

    override fun onError(mp: MediaPlayer, what: Int, extra: Int): Boolean {
        return getBaseMediaPlayer().notifyOnError(what, extra)
    }

    override fun onCompletion(mp: MediaPlayer) {
        getBaseMediaPlayer().notifyOnCompletion()
    }

    override fun onPrepared(mp: MediaPlayer) {
        getBaseMediaPlayer().notifyOnPrepared()
    }

    override fun onBufferingUpdate(mp: MediaPlayer, percent: Int) {
        getBaseMediaPlayer().notifyOnBufferingUpdate(percent)
    }

    override fun onInfo(mp: MediaPlayer, what: Int, extra: Int): Boolean {
        return getBaseMediaPlayer().notifyOnInfo(what, extra)
    }

    override fun onTimedText(mp: MediaPlayer, text: TimedText?) {
        return getBaseMediaPlayer().notifyOnTimedText(text)
    }

    private fun getBaseMediaPlayer(): BaseMediaPlayer {
        return mWeakReference.get() as BaseMediaPlayer
    }

}