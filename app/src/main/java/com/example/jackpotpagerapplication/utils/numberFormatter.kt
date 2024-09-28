package com.example.jackpotpagerapplication.utils

import java.text.NumberFormat
import java.util.Locale

fun formatDoubleWithSpacesAndDecimals(number: Double, digitsAfterPoint: Int): String {
    return String.format("%,.${digitsAfterPoint}f", number).replace(",", " ")
}

fun formatDoubleWithSpaces(value: Double, digitsAfterPoint: Int): String {
    val numberFormat = NumberFormat.getInstance(Locale.getDefault()).apply {
        minimumFractionDigits = digitsAfterPoint
        maximumFractionDigits = digitsAfterPoint
    }

    return numberFormat.format(value).replace(",", " ")
}