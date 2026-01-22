package com.rl.pregnancyvitaltracker.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateTimeUtil {
    private val dateTimeFormatter =
        DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a")

    fun timestampToDateTime(timestamp: Long): String {
        return Instant.ofEpochMilli(timestamp)
            .atZone(ZoneId.systemDefault())
            .format(dateTimeFormatter)
    }
}