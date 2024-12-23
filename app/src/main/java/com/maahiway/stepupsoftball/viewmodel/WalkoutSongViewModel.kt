package com.maahiway.stepupsoftball.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maahiway.stepupsoftball.data.entity.WalkoutSongEntity
import com.maahiway.stepupsoftball.data.repository.WalkoutSongRepository
import kotlinx.coroutines.launch

class WalkoutSongViewModel(private val repository: WalkoutSongRepository) : ViewModel() {
    private val _songs = MutableLiveData<List<WalkoutSongEntity>>()
    val songs: LiveData<List<WalkoutSongEntity>> = _songs

    fun loadAllSongs() {
        viewModelScope.launch {
            _songs.value = repository.getAllSongs()
        }
    }
}