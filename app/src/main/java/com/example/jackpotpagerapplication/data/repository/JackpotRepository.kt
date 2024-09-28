package com.example.jackpotpagerapplication.data.repository

import com.example.jackpotpagerapplication.ui.jackpot.model.JackpotDetailUIModel

interface JackpotRepository {
    suspend fun getJackpotData(): List<JackpotDetailUIModel>
}