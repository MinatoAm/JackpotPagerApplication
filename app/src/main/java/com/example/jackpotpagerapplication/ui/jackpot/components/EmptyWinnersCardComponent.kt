package com.example.jackpotpagerapplication.ui.jackpot.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jackpotpagerapplication.R

@Composable
fun EmptyWinnersCardComponent() {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .height(44.dp)
            .fillMaxWidth(),
        backgroundColor = colorResource(id = R.color.winner_card_bg_color),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.empty_winners_card_text),
                color = colorResource(id = R.color.empty_winners_card_text_color),
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun EmptyWinnersCardComponentPreview() {
    EmptyWinnersCardComponent()
}