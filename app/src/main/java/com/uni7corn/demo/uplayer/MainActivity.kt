package com.uni7corn.demo.uplayer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        video_view.setSourceData("http://vod.sumian.com/fd9448c54bad465d8f3ff9ce50496f14/bca698f4f66f4ff7a21405977b1a0e6c-d9fad1f75459f086ce8a678f0870d442-ld.mp4")
    }
}
