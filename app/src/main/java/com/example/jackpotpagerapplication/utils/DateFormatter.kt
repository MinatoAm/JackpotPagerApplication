package com.example.jackpotpagerapplication.utils

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

fun convertTimeToDateAndTime(input: String): Pair<String, String> {
    val normalizedInput = input.replace("\u202F", " ")

    val inputFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a XXX")
    val dateFormatter = DateTimeFormatter.ofPattern("MM.dd.yyyy")
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    val parsedDateTime = OffsetDateTime.parse(normalizedInput, inputFormatter)

    val date = parsedDateTime.format(dateFormatter)
    val time = parsedDateTime.format(timeFormatter)

    return Pair(date, time)
}