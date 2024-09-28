package com.example.jackpotpagerapplication.ui.jackpot.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jackpotpagerapplication.R
import com.example.jackpotpagerapplication.ui.jackpot.components.EmptyWinnersCardComponent
import com.example.jackpotpagerapplication.ui.jackpot.components.WinnerCardComponent
import com.example.jackpotpagerapplication.ui.jackpot.model.JackpotDetailUIModel
import com.example.jackpotpagerapplication.ui.jackpot.model.JackpotType
import com.example.jackpotpagerapplication.ui.jackpot.model.WinnerUIModel
import com.example.jackpotpagerapplication.utils.formatDoubleWithSpaces

@Composable
fun JackpotCard(
    jackpotType: JackpotType,
    jackpot: JackpotDetailUIModel,
) {
    val winTypeTitleIds = listOf(
        R.string.biggest_win_text,
        R.string.latest_win_text,
    )

    var animatedValue by remember { mutableDoubleStateOf(jackpot.current) }

    val animatedAmount = animateFloatAsState(
        targetValue = animatedValue.toFloat(),
        animationSpec = tween(durationMillis = 300),
        label = "Jackpot Amount Animation"
    )

    LaunchedEffect(jackpot.current) {
        animatedValue = jackpot.current
    }

    val formattedAmount =
        formatDoubleWithSpaces(animatedAmount.value.toDouble(), jackpot.digitsAfterPoint)
    
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = colorResource(id = R.color.jackpot_card_bg_color)
    ) {
        Column {


            Row(
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = Modifier.height(28.dp),
                    painter = painterResource(jackpotType.icon),
                    contentDescription = "Jackpot Icon"
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp),
                    text = stringResource(id = jackpotType.titleId),
                    color = colorResource(id = R.color.primary_text_color),
                    fontSize = 13.sp,
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 12.dp),
                text = formattedAmount,
                color = colorResource(id = R.color.primary_text_color),
                fontSize = 16.sp,
                textAlign = TextAlign.Center

            )
            if (jackpot.winList.isEmpty()) {
                EmptyWinnersCardComponent()
            } else {
                jackpot.winList.forEach {
                    WinnerCardComponent(winner = it, titleId = winTypeTitleIds[0])
                }
            }
        }
    }
}

@Preview
@Composable
private fun JackpotCardPreview() {
    JackpotCard(
        jackpotType = JackpotType(0),
        jackpot = JackpotDetailUIModel(
            id = "clubs",
            current = 100.0,
            digitsAfterPoint = 2,
            wins = "10",
            winList = listOf(
                WinnerUIModel(
                    amount = "50.0",
                    date = "2021-01-01",
                    user = "Alice",
                    time = "13:00"
                ),
                WinnerUIModel(
                    amount = "50.0",
                    date = "2021-01-01",
                    user = "Alice",
                    time = "13:00"
                )
            ),
            topMonthlyWinners = emptyList(),
        )
    )
}