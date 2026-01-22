package com.rl.pregnancyvitaltracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rl.pregnancyvitaltracker.ui.App
import com.rl.pregnancyvitaltracker.ui.theme.PregnancyVitalTrackerTheme
import com.rl.pregnancyvitaltracker.worker.createNotificationChannel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        createNotificationChannel(this)
        setContent {
            PregnancyVitalTrackerTheme {
                App()
            }
        }
    }
}