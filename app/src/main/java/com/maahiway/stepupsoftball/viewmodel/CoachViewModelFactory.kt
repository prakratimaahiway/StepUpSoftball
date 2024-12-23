package com.maahiway.stepupsoftball.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maahiway.stepupsoftball.data.repository.PlayerProfileRepository

class CoachViewModelFactory(private val playerProfileRepository: PlayerProfileRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoachViewModel::class.java)) {
            return CoachViewModel(playerProfileRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
