package com.example.myplayerapp.model

import com.example.myplayerapp.dto.Track

data class FeedModel(
    val tracks: List<Track> = emptyList(),
    val empty: Boolean = false
)