package com.maahiway.stepupsoftball.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maahiway.stepupsoftball.data.entity.PlayerProfileEntity
import com.maahiway.stepupsoftball.data.repository.PlayerProfileRepository
import kotlinx.coroutines.launch

class CoachViewModel(private val playerProfileRepository: PlayerProfileRepository) : ViewModel() {

    private val _team = MutableLiveData<List<PlayerProfileEntity>>()
    val team: LiveData<List<PlayerProfileEntity>> = _team

    init {
        loadTeam()
    }

    private fun loadTeam() {
        // Using viewModelScope.launch to load data asynchronously
        viewModelScope.launch {
            // Get all players from the repository
            _team.value = playerProfileRepository.getAllPlayers()
        }
    }

    fun addPlayerToTeam(playerProfile: PlayerProfileEntity) {
        viewModelScope.launch {
            playerProfileRepository.addPlayerProfile(playerProfile)
            _team.value = _team.value?.plus(playerProfile) ?: listOf(playerProfile)
        }
    }

    fun removePlayerFromTeam(playerId: String) {
        viewModelScope.launch {
            val playerToRemove = _team.value?.find { it.id == playerId }
            playerToRemove?.let {
                playerProfileRepository.deletePlayerProfile(it)
                _team.value = _team.value?.filter { it.id != playerId }
            }
        }
    }
}
