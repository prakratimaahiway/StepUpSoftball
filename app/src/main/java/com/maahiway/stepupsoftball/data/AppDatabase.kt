package com.maahiway.stepupsoftball.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maahiway.stepupsoftball.data.dao.PlayerProfileDao
import com.maahiway.stepupsoftball.data.dao.WalkoutSongDao
import com.maahiway.stepupsoftball.data.entity.PlayerProfileEntity
import com.maahiway.stepupsoftball.data.entity.WalkoutSongEntity

@Database(entities = [PlayerProfileEntity::class, WalkoutSongEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerProfileDao(): PlayerProfileDao
    abstract fun walkoutSongDao(): WalkoutSongDao
}