package com.example.jackpotpagerapplication.data.repository

import com.example.jackpotpagerapplication.data.mapper.toUIModel
import com.example.jackpotpagerapplication.data.network.JackpotApi
import com.example.jackpotpagerapplication.ui.jackpot.model.JackpotDetailUIModel

class JackpotRepositoryImpl(private val api: JackpotApi) : JackpotRepository {
    override suspend fun getJackpotData(): List<JackpotDetailUIModel> {
        val response = api.getJackpotData()
        val currencySymbol = response.currencySymbol ?: ""
        val digitsAfterPoint = response.digitsAfterPoint ?: 2

        return listOf(
            response.clubs to "clubs",
            response.diamonds to "diamonds",
            response.hearts to "hearts",
            response.spades to "spades"
        )
            .sortedByDescending { it.first?.current }
            .mapNotNull { it.first?.toUIModel(it.second, currencySymbol, digitsAfterPoint) }
    }
}