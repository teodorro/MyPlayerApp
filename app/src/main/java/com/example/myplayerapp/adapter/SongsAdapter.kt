package com.example.myplayerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.myplayerapp.databinding.FragmentSongBinding
import com.example.myplayerapp.dto.Song

class SongsAdapter : ListAdapter<Song, SongViewHolder>(SongDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = FragmentSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}