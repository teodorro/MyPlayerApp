package com.example.myplayerapp.model

import com.example.myplayerapp.dto.Album
import com.example.myplayerapp.dto.Track

data class FeedModel(
//    val tracks: List<Track> = emptyList(),
    val album: Album,
    val empty: Boolean = false
)