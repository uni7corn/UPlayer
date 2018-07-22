package com.uni7corn.uplayer.constant

/**
 * Created by dq
 *
 * on 2018/7/22
 *
 * desc:
 */
object MediaPlayStatus {

    const val PLAY_STATUS_IDLE = 0x00

    const val PLAY_STATUS_PREPARE = 0x01
    const val PLAY_STATUS_PLAYING = 0x02
    const val PLAY_STATUS_PAUSE = 0x03
    const val PLAY_STATUS_STOP = 0x04
    const val PLAY_STATUS_COMPLETE = 0x05

    const val PLAY_STATUS_ERROR = 0xff
}