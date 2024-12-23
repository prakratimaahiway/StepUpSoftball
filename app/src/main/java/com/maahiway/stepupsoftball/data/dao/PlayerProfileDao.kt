package com.maahiway.stepupsoftball.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.maahiway.stepupsoftball.data.entity.PlayerProfileEntity

@Dao
interface PlayerProfileDao {

    @Insert
    suspend fun insertPlayerProfile(playerProfile: PlayerProfileEntity)

    @Query("SELECT * FROM player_profiles WHERE id = :id")
    suspend fun getPlayerProfile(id: String): PlayerProfileEntity?

    // Ensure this function is 'suspend' to work with Room's async nature
    @Query("SELECT * FROM player_profiles")
    suspend fun getAllPlayers(): List<PlayerProfileEntity>

    @Delete
    suspend fun deletePlayerProfile(playerProfile: PlayerProfileEntity)

    @Query("SELECT * FROM player_profiles WHERE id = :playerId")
    suspend fun getPlayerProfileById(playerId: String): PlayerProfileEntity?
}