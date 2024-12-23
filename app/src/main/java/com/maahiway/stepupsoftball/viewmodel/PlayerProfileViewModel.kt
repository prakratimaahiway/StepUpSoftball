package com.maahiway.stepupsoftball.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maahiway.stepupsoftball.data.entity.PlayerProfileEntity
import com.maahiway.stepupsoftball.data.repository.PlayerProfileRepository
import kotlinx.coroutines.launch

//PlayerProfileViewModel will interact with the repository to manage player profiles and allow updates to the walkout song.
class PlayerProfileViewModel(private val playerProfileRepository: PlayerProfileRepository) : ViewModel() {

    //I use LiveData to observe the player profile in the UI.
    private val _playerProfile = MutableLiveData<PlayerProfileEntity>()
    val playerProfile: LiveData<PlayerProfileEntity> = _playerProfile

    fun loadPlayerProfile(playerId: String) {
        viewModelScope.launch {
            _playerProfile.value = playerProfileRepository.getPlayerProfile(playerId)
        }
    }

    fun updateWalkoutSong(playerId: String, newWalkoutSongId: String) {
        viewModelScope.launch {
            val currentProfile = _playerProfile.value
            currentProfile?.let {
                val updatedProfile = it.copy(walkoutSongId = newWalkoutSongId)
                playerProfileRepository.addPlayerProfile(updatedProfile) // Update in DB
                _playerProfile.value = updatedProfile // Update LiveData
            }
        }
    }

    fun removePlayer(playerId: String) {
        viewModelScope.launch {
            _playerProfile.value?.let {
                playerProfileRepository.deletePlayerProfile(it)
            }
        }
    }
}