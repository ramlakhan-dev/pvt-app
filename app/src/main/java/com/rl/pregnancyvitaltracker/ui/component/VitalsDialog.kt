package com.rl.pregnancyvitaltracker.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.rl.pregnancyvitaltracker.data.model.Vital

@Composable
fun VitalsDialog(
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onSubmit: (Vital) -> Unit
) {


    var sysBp by remember { mutableStateOf("") }
    var diaBp by remember { mutableStateOf("") }
    var heartRate by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var babyKicks by remember { mutableStateOf("") }

    LaunchedEffect(showDialog) {
        if (showDialog) {
            sysBp = ""
            diaBp = ""
            heartRate = ""
            weight = ""
            babyKicks = ""
        }
    }

    if (showDialog) {
        Dialog(
            onDismissRequest = onDismiss
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = modifier.padding(24.dp)
                ) {
                    Text(
                        text = "Add Vitals",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(16.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = sysBp,
                            onValueChange = {
                                sysBp = it
                            },
                            placeholder = {
                                Text(
                                    text = "Sys BP"
                                )
                            },
                            singleLine = true,
                            modifier = Modifier.padding(4.dp).weight(1f)
                        )

                        OutlinedTextField(
                            value = diaBp,
                            onValueChange = {
                                diaBp = it
                            },
                            placeholder = {
                                Text(
                                    text = "Dia BP"
                                )
                            },
                            singleLine = true,
                            modifier = Modifier.padding(4.dp).weight(1f)
                        )
                    }

                    OutlinedTextField(
                        value = heartRate,
                        onValueChange = {
                            heartRate = it
                        },
                        placeholder = {
                            Text(
                                text = "Heart Rate"
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(4.dp)

                    )

                    OutlinedTextField(
                        value = weight,
                        onValueChange = {
                            weight = it
                        },
                        placeholder = {
                            Text(
                                text = "Weight (in Kg)"
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(4.dp)

                    )

                    OutlinedTextField(
                        value = babyKicks,
                        onValueChange = {
                            babyKicks = it
                        },
                        placeholder = {
                            Text(
                                text = "Baby Kicks"
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(4.dp)
                    )

                    Button(
                        onClick = { onSubmit(
                            Vital(
                                systolicBP = sysBp.toInt(),
                                diastolicBP = diaBp.toInt(),
                                heartRate = heartRate.toInt(),
                                weight = weight.toFloat(),
                                babyKicksCount = babyKicks.toInt()
                            )
                        ) },
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    ) {
                        Text(
                            text = "Submit"
                        )
                    }
                }
            }
        }
    }


}