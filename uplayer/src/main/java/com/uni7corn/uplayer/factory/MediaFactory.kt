package com.uni7corn.uplayer.factory

import android.content.Context
import com.uni7corn.uplayer.player.IMediaPlayer

/**
 * Created by dq
 *
 * on 2018/7/22
 *
 * desc:
 */
class MediaFactory {

    companion object {

        fun create(context: Context, clx: Class<out IMediaPlayer>): IMediaPlayer {
            return clx.getConstructor(Context::class.java).newInstance(context)
        }
    }

}