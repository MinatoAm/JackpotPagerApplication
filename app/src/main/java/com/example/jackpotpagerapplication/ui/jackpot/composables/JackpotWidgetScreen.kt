package com.example.jackpotpagerapplication.ui.jackpot.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.jackpotpagerapplication.R
import com.example.jackpotpagerapplication.ui.jackpot.JackpotState
import com.example.jackpotpagerapplication.ui.jackpot.JackpotViewModel
import com.example.jackpotpagerapplication.ui.jackpot.components.JackpotWidgetComponent
import com.example.jackpotpagerapplication.ui.jackpot.model.JackpotType
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun JackpotWidgetScreen(modifier: Modifier) {
    val viewModel: JackpotViewModel = koinViewModel()
    val state by viewModel.jackpotState.collectAsState()

    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            JackpotModalSheet()
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.jackpot_widget_screen_bg_color)),
            contentAlignment = Alignment.Center
        ) {
            when (val currentState = state) {
                is JackpotState.Loading -> {
                    CircularProgressIndicator()
                }

                is JackpotState.Error -> {
                    Text(
                        text = currentState.message,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                is JackpotState.Success -> {
                    LazyRow(modifier = Modifier
                        .clickable {
                            scope.launch {
                                sheetState.show()
                            }
                        }
                        .padding(horizontal = 8.dp)) {
                        itemsIndexed(
                            currentState.jackpots,
                            key = { _, item -> item.id }) { index, jackpot ->
                            JackpotWidgetComponent(
                                modifier.fillMaxWidth(),
                                current = jackpot.current,
                                digitsAfterPoint = jackpot.digitsAfterPoint,
                                jackpotType = JackpotType(index)
                            )
                        }
                    }
                }
            }
        }
    }
}