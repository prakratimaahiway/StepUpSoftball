package com.maahiway.stepupsoftball.data.repository

import com.maahiway.stepupsoftball.data.dao.PlayerProfileDao
import com.maahiway.stepupsoftball.data.entity.PlayerProfileEntity

// PlayerProfileRepository repository will interact with the DAO to fetch and update player profiles
class PlayerProfileRepository(private val playerProfileDao: PlayerProfileDao) {

    // Suspend function for getting all players asynchronously
    suspend fun getAllPlayers(): List<PlayerProfileEntity> {
        return playerProfileDao.getAllPlayers()
    }

    suspend fun addPlayerProfile(playerProfile: PlayerProfileEntity) {
        playerProfileDao.insertPlayerProfile(playerProfile)
    }

    suspend fun deletePlayerProfile(playerProfile: PlayerProfileEntity) {
        playerProfileDao.deletePlayerProfile(playerProfile)
    }

    suspend fun getPlayerProfile(playerId: String): PlayerProfileEntity? {
        return playerProfileDao.getPlayerProfileById(playerId)
    }
}