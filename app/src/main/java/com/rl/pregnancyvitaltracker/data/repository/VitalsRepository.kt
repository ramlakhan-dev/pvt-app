package com.rl.pregnancyvitaltracker.data.repository

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.rl.pregnancyvitaltracker.data.local.dao.VitalsDao
import com.rl.pregnancyvitaltracker.data.model.Vital
import com.rl.pregnancyvitaltracker.worker.ReminderWorker
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class VitalsRepository @Inject constructor(
    private val vitalsDao: VitalsDao,
    @ApplicationContext private val context: Context
) {

    fun getAllVitals(): Flow<List<Vital>> {
        return vitalsDao.getAllVitals()
    }

    suspend fun insert(vital: Vital) {
        vitalsDao.insert(vital)
    }

    fun scheduleVitalsReminder() {
        val workRequest = PeriodicWorkRequestBuilder<ReminderWorker>(5, TimeUnit.HOURS)
            .setInitialDelay(5, TimeUnit.HOURS)
            .build()

        WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork(
                "vitals_reminder_work",
                ExistingPeriodicWorkPolicy.REPLACE,
                workRequest
            )
    }
}