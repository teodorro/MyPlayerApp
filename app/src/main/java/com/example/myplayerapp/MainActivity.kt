package com.example.myplayerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myplayerapp.observers.MediaLifecycleObserver

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val mediaObserver = MediaLifecycleObserver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(mediaObserver)


    }
}