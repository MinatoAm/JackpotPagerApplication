package com.example.jackpotpagerapplication.ui.jackpot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jackpotpagerapplication.data.repository.JackpotRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class JackpotViewModel(private val repository: JackpotRepository) : ViewModel() {
    private val _jackpotState = MutableStateFlow<JackpotState>(JackpotState.Loading)
    val jackpotState: StateFlow<JackpotState> = _jackpotState

    init {
        startFetchingData()
    }

    private fun startFetchingData() {
        viewModelScope.launch {
            while (true) {
                try {
                    val jackpots = repository.getJackpotData()
                    if (jackpots.isNotEmpty()) _jackpotState.value = JackpotState.Success(jackpots)
                } catch (e: Exception) {
                    _jackpotState.value = JackpotState.Error(e.message ?: "Unknown Error")
                }
                delay(5000)
            }
        }
    }
}