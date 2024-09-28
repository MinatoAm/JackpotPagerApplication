package com.example.jackpotpagerapplication.data.network

import com.example.jackpotpagerapplication.data.model.JackpotResponse
import retrofit2.http.GET

interface JackpotApi {
    @GET("Statistics/GetJackpot")
    suspend fun getJackpotData(): JackpotResponse
}