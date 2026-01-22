package com.rl.pregnancyvitaltracker.di

import android.content.Context
import androidx.room.Room
import com.rl.pregnancyvitaltracker.data.local.dao.VitalsDao
import com.rl.pregnancyvitaltracker.data.local.database.VitalsDatabase
import com.rl.pregnancyvitaltracker.data.repository.VitalsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideVitalsDatabase(@ApplicationContext context: Context): VitalsDatabase {
        return Room.databaseBuilder(
            context,
            VitalsDatabase::class.java,
            "vitals_db"
        ).build()
    }

    @Provides
    fun provideVitalsDao(db: VitalsDatabase): VitalsDao {
        return db.vitalsDao()
    }

    @Provides
    fun provideVitalRepository(vitalsDao: VitalsDao, @ApplicationContext context: Context): VitalsRepository {
        return VitalsRepository(vitalsDao, context)
    }
}