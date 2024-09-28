package com.example.jackpotpagerapplication.data.model

data class JackpotResponse(
    val digitsAfterPoint: Int?,
    val currency: String?,
    val currencySymbol: String?,
    val clubs: JackpotData?,
    val diamonds: JackpotData?,
    val hearts: JackpotData?,
    val spades: JackpotData?,
)

data class JackpotData(
    val current: Double?,
    val wins: Int?,
    val largestWin: Double?,
    val largestWinDate: String?,
    val largestWinUser: String?,
    val lastWin: Double?,
    val lastWinDate: String?,
    val lastWinUser: String?,
    val topMonthlyWinners: List<Winner>?,
)

data class Winner(
    val winUser: String,
    val winAmount: Double,
    val winDate: String
)