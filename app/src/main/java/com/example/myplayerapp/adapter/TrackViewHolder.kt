package com.example.myplayerapp.adapter

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.myplayerapp.R
import com.example.myplayerapp.databinding.TrackItemBinding
import com.example.myplayerapp.dto.Track
import com.example.myplayerapp.observers.MediaLifecycleObserver
import com.example.myplayerapp.viewModel.MainViewModel
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources.getDrawable


class TrackViewHolder(
    private val mediaObserver: MediaLifecycleObserver,
    private val binding: TrackItemBinding,
    private val adapter: TrackAdapter
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(track: Track) {
        binding.apply {
            trackName.text = track.file
            stateButton.setOnClickListener {
                val url = "${MainViewModel.BASE_URL}${track.file}"

                var a = adapter.currentTrackBinding
                var b = mediaObserver.currentUrl
                var c = mediaObserver
                var d = mediaObserver.player


                if (mediaObserver.currentUrl.isNotBlank() && mediaObserver.currentUrl != url) {
                    mediaObserver.onStop()
                    adapter.currentTrackBinding!!.stateButton.icon = getDrawable(
                        binding.root.context,
                        R.drawable.ic_baseline_play_circle_filled_32
                    )
                }

                if (mediaObserver.player == null || mediaObserver.player?.isPlaying!!) {
                    mediaObserver?.onPause()
                    stateButton.icon = getDrawable(
                        binding.root.context,
                        R.drawable.ic_baseline_play_circle_filled_32
                    )
                } else {
                    mediaObserver.apply {
                        if (currentUrl != url || currentUrl.isBlank())
                            player?.setDataSource(url)
                    }.play()
                    stateButton.icon = getDrawable(
                        binding.root.context,
                        R.drawable.ic_baseline_pause_circle_filled_32
                    )
                    mediaObserver.currentUrl = url
                    adapter.currentTrackBinding = binding
                }
            }
        }
    }


}