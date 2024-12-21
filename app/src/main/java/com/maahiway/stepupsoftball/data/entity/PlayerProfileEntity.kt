package com.maahiway.stepupsoftball.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_profiles")
data class PlayerProfileEntity(
    @PrimaryKey val id: String,
    val name: String,
    val teamName: String,
    val walkoutSongId: String
)
