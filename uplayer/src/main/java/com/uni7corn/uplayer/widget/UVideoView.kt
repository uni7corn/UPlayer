package com.uni7corn.uplayer.widget

import android.content.Context
import android.graphics.SurfaceTexture
import android.media.TimedText
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.util.Log
import android.view.Surface
import android.view.TextureView
import android.view.View
import android.widget.FrameLayout
import com.uni7corn.uplayer.R
import com.uni7corn.uplayer.builder.SourceDataBuilder
import com.uni7corn.uplayer.delegate.ScreenDelegate
import com.uni7corn.uplayer.factory.MediaFactory
import com.uni7corn.uplayer.listener.OnIMediaPlayerListener
import com.uni7corn.uplayer.player.AndroidMediaPlayer
import com.uni7corn.uplayer.player.IMediaPlayer
import kotlinx.android.synthetic.main.lay_video_view.view.*
import java.lang.ref.WeakReference

/**
 * Created by dq
 *
 * on 2018/7/17
 *
 * desc: 自定义 cbti video view
 */
class UVideoView : FrameLayout, IUVideoView, VideoBannerView.OnBannerCallback, VideoController.OnControllerCallback, TextureView.SurfaceTextureListener, OnIMediaPlayerListener, UTextureView.OnTextureViewCallback {

    private val TAG = UVideoView::class.java.simpleName

    private val mAndroidMediaPlayer: IMediaPlayer by lazy {

        val iMediaPlayer = MediaFactory.create(context, AndroidMediaPlayer::class.java)

        // 设置监听

        iMediaPlayer.setOnIMediaPlayerListener(this@UVideoView)

        return@lazy iMediaPlayer
    }

    private var mSurfaceTexture: SurfaceTexture? = null

    private var mSurface: Surface? = null

    private var mWeakActivityReference: WeakReference<AppCompatActivity>? = null

    private lateinit var mScreenDelegate: ScreenDelegate

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    private fun initView(context: Context) {
        View.inflate(context, R.layout.lay_video_view, this)
        video_banner.setOnBannerCallback(this)
        texture_view.surfaceTextureListener = this
        texture_view.setOnTextureViewCallback(this)
        video_controller.setOnControllerCallback(this)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.e(TAG, "onMeasure")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.e(TAG, "onSizeChanged   w=$w h=$h oldw=$oldw  oldh=$oldh")
    }

    override fun setUp(activity: AppCompatActivity): IUVideoView {
        this.mWeakActivityReference = WeakReference(activity)
        this.mScreenDelegate = ScreenDelegate().setUp(activity)
        return this
    }

    override fun setSourceData(url: String) {
        val sourceData = SourceDataBuilder().setId(1).setTitle("测试").setUrl(url).build()
        mAndroidMediaPlayer.setSourceData(sourceData)
    }

    override fun showController() {
        video_banner.show()
        video_controller.show()
    }

    override fun dismissController() {
        video_banner.autoDismiss()
        video_controller.autoDismiss()
    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {
        // SurfaceTexture缓冲大小变化
        Log.e(TAG, "onSurfaceTextureSizeChanged  width=$width   height=$height")
        // texture_view.adaptVideoSize(width, height)
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {
        // SurfaceTexture通过updateImage更新
        // Log.e(TAG, "onSurfaceTextureUpdated----->")
    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
        // SurfaceTexture即将被销毁
        Log.e(TAG, "onSurfaceTextureDestroyed----->")
        return mSurfaceTexture == null
    }

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
        Log.e(TAG, "onSurfaceTextureAvailable----->width=$width   height=$height")
        // SurfaceTexture准备就绪,打开播放器
        if (mSurfaceTexture == null) {
            this.mSurfaceTexture = surface
            openMediaPlayer(surface)
        } else {
            texture_view.surfaceTexture = mSurfaceTexture
        }
    }


    private fun openMediaPlayer(surface: SurfaceTexture) {
        keepScreenOn = true

        if (mSurface == null) {
            this.mSurface = Surface(surface)
        }

        mAndroidMediaPlayer.setSurface(mSurface!!)

        mAndroidMediaPlayer.play()
    }


    override fun showExtraContent() {

    }

    override fun play() {
        mAndroidMediaPlayer.play()
    }

    override fun pause() {
        mAndroidMediaPlayer.pause()
    }

    override fun goBack() {

    }

    override fun showMenu() {

    }

    override fun enterFullScreen() {
        this.mScreenDelegate.enterFullScreen(this)
    }

    override fun exitFullScreen(): Boolean {
        this.mScreenDelegate.exitFullScreen(this)
        return false
    }

    override fun enterTinyWindow() {
        this.mScreenDelegate.enterTinyWindow(this)
    }

    override fun exitTinyWindow(): Boolean {
        return false
    }

    override fun seekTo(position: Int): Boolean {
        mAndroidMediaPlayer.seekTo(position)
        return true
    }

    override fun onCompletion(iMediaPlayer: IMediaPlayer) {
        Log.e(TAG, "onCompletion  ")
    }

    override fun onPrepared(iMediaPlayer: IMediaPlayer) {
        Log.e(TAG, "onPrepared  ")
        //  mBitmap = texture_view.bitmap
        // background = BitmapDrawable(mBitmap).current
        iMediaPlayer.start()
    }

    override fun onInfo(iMediaPlayer: IMediaPlayer, what: Int, extra: Int): Boolean {
        Log.e(TAG, "onInfo   what=$what   extra=$extra")
        return true
    }

    override fun onSeekComplete(iMediaPlayer: IMediaPlayer) {
        Log.e(TAG, "onSeekComplete")
    }

    override fun onTimedText(iMediaPlayer: IMediaPlayer, text: TimedText?) {
        Log.e(TAG, "onTimedText text=${text.toString()}")
    }

    override fun onError(iMediaPlayer: IMediaPlayer, what: Int, extra: Int): Boolean {
        Log.e(TAG, "onError  what=$what   extra=$extra")
        return false
    }

    override fun onBufferingUpdate(iMediaPlayer: IMediaPlayer, percent: Int) {
        Log.e(TAG, "onBufferingUpdate   percent=$percent")
    }

    override fun onVideoSizeChanged(iMediaPlayer: IMediaPlayer, width: Int, height: Int) {

    }
}