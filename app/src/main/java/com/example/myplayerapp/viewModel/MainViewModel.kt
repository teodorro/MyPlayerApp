package com.example.myplayerapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myplayerapp.model.FeedModel
import com.example.myplayerapp.repository.TrackRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: TrackRepository,)
    : ViewModel() {

    val data: LiveData<FeedModel> =
        repository.data.map { tracks ->
            FeedModel(
                tracks.map { it.copy() },
                tracks.isEmpty()
            )
        }.asLiveData()

    init {
        loadTracks()
    }

    private fun loadTracks() {
        //TODO("Not yet implemented")
    }
}