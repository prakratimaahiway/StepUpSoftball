package com.maahiway.stepupsoftball.data.repository

import com.maahiway.stepupsoftball.data.dao.WalkoutSongDao
import com.maahiway.stepupsoftball.data.entity.WalkoutSongEntity

class WalkoutSongRepository(private val walkoutSongDao: WalkoutSongDao) {
    suspend fun getAllSongs(): List<WalkoutSongEntity> {
        return walkoutSongDao.getAllSongs()
    }
}