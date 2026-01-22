package com.rl.pregnancyvitaltracker.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rl.pregnancyvitaltracker.data.model.Vital
import com.rl.pregnancyvitaltracker.utils.DateTimeUtil

@Composable
fun VitalsItem(
    modifier: Modifier = Modifier,
    vital: Vital
) {


    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.MonitorHeart,
                        contentDescription = "Heart"
                    )

                    Text(
                        text = vital.heartRate.toString() + " bpm",
                        modifier = Modifier.padding(horizontal = 4.dp)

                    )
                }

                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ShowChart,
                        contentDescription = "Blood Pressure"
                    )

                    Text(
                        text = vital.systolicBP.toString() + "/" + vital.diastolicBP.toString() + " mmHg",
                        modifier = Modifier.padding(horizontal = 4.dp)

                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.MonitorWeight,
                        contentDescription = "Weight"
                    )

                    Text(
                        text = vital.weight.toString() + " kg",
                        modifier = Modifier.padding(horizontal = 4.dp)

                    )
                }

                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.ChildCare,
                        contentDescription = "Baby Kicks"
                    )

                    Text(
                        text = vital.babyKicksCount.toString() + " kicks",
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }
            }

        }

        Row (
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primaryContainer),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = DateTimeUtil.timestampToDateTime(vital.timestamp),
                modifier = Modifier.padding(16.dp)
            )
        }

    }

}