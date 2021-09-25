package com.example.myplayerapp.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.myplayerapp.R
import com.example.myplayerapp.adapter.TrackAdapter
import com.example.myplayerapp.databinding.ActivityMainBinding
import com.example.myplayerapp.databinding.TrackItemBinding
import com.example.myplayerapp.observers.MediaLifecycleObserver
import com.example.myplayerapp.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()
    private val mediaObserver = MediaLifecycleObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(mediaObserver)

        val adapter = TrackAdapter(mediaObserver)
        binding.tracksRecyclerView.adapter = adapter
        viewModel.data.observe(this){ state ->
            adapter.submitList(state.album.tracks)
        }
    }
}