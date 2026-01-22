package com.rl.pregnancyvitaltracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rl.pregnancyvitaltracker.data.model.Vital
import com.rl.pregnancyvitaltracker.data.repository.VitalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VitalsViewModel @Inject constructor(
    private val vitalsRepository: VitalsRepository
): ViewModel() {

    val allVitals: Flow<List<Vital>> = vitalsRepository.getAllVitals()


    fun insert(vital: Vital) {
        viewModelScope.launch {
            vitalsRepository.insert(vital)
        }
    }

    fun startReminder() {
        vitalsRepository.scheduleVitalsReminder()
    }
}