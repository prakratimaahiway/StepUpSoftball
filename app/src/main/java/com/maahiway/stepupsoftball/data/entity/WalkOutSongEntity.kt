package com.maahiway.stepupsoftball.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "walkout_songs")
data class WalkoutSongEntity(
    @PrimaryKey val id: String,
    val title: String,
    val artist: String
)