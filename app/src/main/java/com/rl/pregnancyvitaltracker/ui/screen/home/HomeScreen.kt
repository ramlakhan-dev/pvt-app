package com.rl.pregnancyvitaltracker.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rl.pregnancyvitaltracker.ui.component.VitalsItem
import com.rl.pregnancyvitaltracker.viewmodel.VitalsViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    vitalViewModel: VitalsViewModel
) {


    val vitalList = vitalViewModel.allVitals.collectAsState(initial = emptyList()).value

    if (vitalList.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "No Vitals"
            )
        }
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
        ) {

            items(vitalList) {vital ->
                VitalsItem (
                    modifier = Modifier.padding(16.dp),
                    vital = vital
                )
            }
        }
    }
}