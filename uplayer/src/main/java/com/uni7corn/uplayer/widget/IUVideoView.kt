package com.uni7corn.uplayer.widget

import android.support.v7.app.AppCompatActivity

/**
 * Created by sm
 *
 * on 2018/7/23
 *
 * desc:
 *
 */
interface IUVideoView {

    /**
     * 绑定当前的 activity
     */
    fun setUp(activity: AppCompatActivity): IUVideoView

    /**
     * 设置播放文件
     */
    fun setSourceData(url: String)

    /**
     * 进入全屏模式
     */
    fun enterFullScreen()

    /**
     * 退出全屏  true?  退出成功
     */
    fun exitFullScreen(): Boolean

    /**
     * 进入小窗口模式
     */
    fun enterTinyWindow()

    /**
     * 退出小窗口 true?  退出成功
     */
    fun exitTinyWindow(): Boolean


}