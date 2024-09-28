package com.example.jackpotpagerapplication.ui.jackpot

import com.example.jackpotpagerapplication.ui.jackpot.model.JackpotDetailUIModel

sealed class JackpotState {
    data object Loading : JackpotState()
    data class Success(val jackpots: List<JackpotDetailUIModel>) : JackpotState()
    data class Error(val message: String) : JackpotState()
}