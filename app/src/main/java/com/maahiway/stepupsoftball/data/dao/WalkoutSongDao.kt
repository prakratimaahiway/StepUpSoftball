package com.maahiway.stepupsoftball.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.maahiway.stepupsoftball.data.entity.WalkoutSongEntity

@Dao
interface WalkoutSongDao {
    @Insert
    suspend fun insertWalkoutSong(walkoutSong: WalkoutSongEntity)

    @Query("SELECT * FROM walkout_songs")
    suspend fun getAllSongs(): List<WalkoutSongEntity>
}