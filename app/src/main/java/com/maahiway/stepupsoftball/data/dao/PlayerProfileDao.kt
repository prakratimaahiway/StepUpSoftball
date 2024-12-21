package com.maahiway.stepupsoftball.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.maahiway.stepupsoftball.data.entity.PlayerProfileEntity

@Dao
interface PlayerProfileDao {
    @Insert
    suspend fun insertPlayerProfile(playerProfile: PlayerProfileEntity)

    @Query("SELECT * FROM player_profiles WHERE id = :id")
    suspend fun getPlayerProfile(id: String): PlayerProfileEntity?
}