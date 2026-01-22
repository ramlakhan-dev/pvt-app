package com.rl.pregnancyvitaltracker.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rl.pregnancyvitaltracker.data.local.dao.VitalsDao
import com.rl.pregnancyvitaltracker.data.model.Vital

@Database(entities = [Vital::class], version = 1)
abstract class VitalsDatabase: RoomDatabase() {

    abstract fun vitalsDao(): VitalsDao
}