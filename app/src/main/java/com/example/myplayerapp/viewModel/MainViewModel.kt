package com.example.myplayerapp.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    init {
        loadSongs()
    }

    private fun loadSongs() {
        TODO("Not yet implemented")
    }
}