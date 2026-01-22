package com.rl.pregnancyvitaltracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vitals")
data class Vital(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val systolicBP: Int,
    val diastolicBP: Int,

    val heartRate: Int,
    val weight: Float,
    val babyKicksCount: Int,

    val timestamp: Long = System.currentTimeMillis()
)
