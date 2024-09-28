package com.example.jackpotpagerapplication.ui.jackpot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import com.example.jackpotpagerapplication.ui.jackpot.model.WinnerUIModel

@Composable
fun WinnerCardComponent(winner: WinnerUIModel, titleId: Int) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        backgroundColor = colorResource(id = R.color.winner_card_bg_color),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Row(modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp)) {
                Text(
                    text = stringResource(id = titleId),
                    color = colorResource(id = R.color.winner_card_winner_type_text_color),
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = winner.amount,
                    color = colorResource(id = R.color.winner_card_winner_type_text_color),
                    textAlign = TextAlign.End,
                    fontSize = 14.sp,
                )
            }
            Row(
                modifier = Modifier.padding(
                    top = 8.dp,
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 12.dp
                )
            ) {
                Text(
                    text = winner.date,
                    color = colorResource(id = R.color.winner_card_date_text_color),
                    textAlign = TextAlign.Start,
                    fontSize = 11.sp,
                )
                Divider(
                    Modifier
                        .padding(horizontal = 3.dp)
                        .height(8.dp)
                        .width(1.dp)
                        .align(Alignment.CenterVertically)
                        .background(
                            color = colorResource(id = R.color.winner_card_divider_color),
                            shape = RoundedCornerShape(8.dp)
                        ),
                )
                Text(
                    text = winner.time,
                    color = colorResource(id = R.color.winner_card_date_text_color),
                    textAlign = TextAlign.End,
                    fontSize = 11.sp,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.winner_card_bet_id_text, winner.user),
                    color = colorResource(id = R.color.winner_card_date_text_color),
                    textAlign = TextAlign.End,
                    fontSize = 11.sp,
                )
            }
        }
    }
}

@Preview
@Composable
private fun WinnerCardComponentPreview() {
    WinnerCardComponent(
        WinnerUIModel("Alice", "100.0", "2021-01-01", "13:00"),
        R.string.biggest_win_text
    )
}