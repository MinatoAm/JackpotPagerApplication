package com.example.jackpotpagerapplication.data.mapper

import com.example.jackpotpagerapplication.data.model.JackpotData
import com.example.jackpotpagerapplication.ui.jackpot.model.JackpotDetailUIModel
import com.example.jackpotpagerapplication.ui.jackpot.model.WinnerUIModel
import com.example.jackpotpagerapplication.utils.convertTimeToDateAndTime
import com.example.jackpotpagerapplication.utils.formatDoubleWithSpacesAndDecimals

fun JackpotData.toUIModel(
    id: String,
    currencySymbol: String,
    digitsAfterPoint: Int,
): JackpotDetailUIModel {
    val (largestWinDate, largestWinTime) = convertTimeToDateAndTime(largestWinDate ?: "")
    val (lastWinDate, lastWinTime) = convertTimeToDateAndTime(lastWinDate ?: "")
    val winList = mutableListOf<WinnerUIModel>()
    if (lastWin != null) {
        winList.add(
            WinnerUIModel(
                amount = "${formatDoubleWithSpacesAndDecimals(largestWin?: 0.0, digitsAfterPoint)} $currencySymbol",
                date = largestWinDate,
                user = largestWinUser ?: "****",
                time = largestWinTime
            )
        )
        winList.add(
            WinnerUIModel(
                amount = "${formatDoubleWithSpacesAndDecimals(lastWin, digitsAfterPoint)} $currencySymbol",
                date = lastWinDate,
                user = lastWinUser ?: "****",
                time = lastWinTime
            )
        )
    }

    return JackpotDetailUIModel(
        id = id,
        digitsAfterPoint = digitsAfterPoint,
//        current = "${formatDoubleWithSpacesAndDecimals(current ?: 0.0, digitsAfterPoint)} $currencySymbol",
        current = current?: 0.0,
        wins = wins?.toString() ?: "N/A",
        winList = winList,
        topMonthlyWinners = topMonthlyWinners?.map {
            val (date, time) = convertTimeToDateAndTime(it.winDate)
            WinnerUIModel(
                user = it.winUser,
                amount = "${formatDoubleWithSpacesAndDecimals(it.winAmount, digitsAfterPoint)} $currencySymbol",
                date = date,
                time = time
            )
        } ?: emptyList(),
    )
}