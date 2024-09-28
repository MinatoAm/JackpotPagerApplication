package com.example.jackpotpagerapplication.ui.jackpot.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jackpotpagerapplication.R
import com.example.jackpotpagerapplication.ui.jackpot.model.JackpotType
import com.example.jackpotpagerapplication.utils.formatDoubleWithSpaces

@Composable
fun JackpotWidgetComponent(
    modifier: Modifier,
    current: Double,
    digitsAfterPoint: Int,
    jackpotType: JackpotType
) {
    var animatedValue by remember { mutableDoubleStateOf(current) }

    val animatedAmount = animateFloatAsState(
        targetValue = animatedValue.toFloat(),
        animationSpec = tween(durationMillis = 300),
        label = "Jackpot Amount Animation"
    )

    LaunchedEffect(current) {
        animatedValue = current
    }

    val formattedAmount = formatDoubleWithSpaces(animatedAmount.value.toDouble(), digitsAfterPoint)

    Card(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .height(56.dp)
            .width(336.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = colorResource(id = R.color.jackpot_widget_component_bg_color)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = jackpotType.background),
            contentDescription = ""
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .height(36.dp)
                    .padding(start = 16.dp),
                painter = painterResource(id = jackpotType.icon),
                contentDescription = "Jackpot Widget Icon"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                text = formattedAmount,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                color = colorResource(
                    id = R.color.widget_current_text_color
                )
            )
        }
    }
}

@Preview
@Composable
private fun JackpotWidgetComponentPreview() {
    JackpotWidgetComponent(
        modifier = Modifier.fillMaxWidth(),
        current = 1000000.00,
        digitsAfterPoint = 2,
        jackpotType = JackpotType(0)
    )
}