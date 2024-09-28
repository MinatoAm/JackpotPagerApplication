package com.example.jackpotpagerapplication.ui.jackpot.model


data class JackpotDetailUIModel(
    val id: String,
    val digitsAfterPoint: Int,
    val current: Double,
    val wins: String,
    val winList: List<WinnerUIModel>,
    val topMonthlyWinners: List<WinnerUIModel>,
)

data class WinnerUIModel(
    val user: String,
    val amount: String,
    val date: String,
    val time: String
)
