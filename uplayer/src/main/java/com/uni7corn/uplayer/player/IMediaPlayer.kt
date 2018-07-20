package com.uni7corn.uplayer.player

/**
 * Created by dq
 *
 * on 2018/7/18
 *
 * desc:
 */
interface IMediaPlayer {

    fun play()

    fun play(position: Int)

    fun reset()

    fun release()

    fun rePlay()
}