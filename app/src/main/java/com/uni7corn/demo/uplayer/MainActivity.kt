package com.uni7corn.demo.uplayer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.uni7corn.uplayer.factory.MediaFactory
import com.uni7corn.uplayer.player.AMediaPlayer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iMediaPlayer = MediaFactory.create(this, AMediaPlayer::class.java)

    }
}
