package com.example.jackpotpagerapplication.ui.jackpot.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.jackpotpagerapplication.R
import com.example.jackpotpagerapplication.ui.jackpot.JackpotState
import com.example.jackpotpagerapplication.ui.jackpot.JackpotViewModel
import com.example.jackpotpagerapplication.ui.jackpot.model.JackpotType
import org.koin.androidx.compose.koinViewModel


@Composable
fun JackpotModalSheet() {
    val viewModel: JackpotViewModel = koinViewModel()
    val state by viewModel.jackpotState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.jackpot_widget_screen_bg_color)),
        contentAlignment = Alignment.Center
    ) {
        when (val currentState = state) {
            is JackpotState.Loading -> {
                CircularProgressIndicator()
            }

            is JackpotState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp)
                ) {
                    itemsIndexed(currentState.jackpots) { index, jackpot ->
                        JackpotCard(
                            jackpotType = JackpotType(index),
                            jackpot,
                        )
                    }
                }
            }

            is JackpotState.Error -> {
                Text(
                    text = currentState.message,
                    color = colorResource(id = R.color.primary_text_color)
                )
            }
        }
    }
}