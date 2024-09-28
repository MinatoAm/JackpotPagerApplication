package com.example.jackpotpagerapplication.ui.jackpot.model

import com.example.jackpotpagerapplication.R

data class JackpotType(val index: Int) {
    val icon = when (index) {
        0 -> R.drawable.diamond
        1 -> R.drawable.gold
        2 -> R.drawable.silver
        3 -> R.drawable.bronze
        else -> R.drawable.diamond
    }
    val titleId = when (index) {
        0 -> R.string.winner_card_diamond_title
        1 -> R.string.winner_card_gold_title
        2 -> R.string.winner_card_silver_title
        3 -> R.string.winner_card_copper_title
        else -> R.string.winner_card_diamond_title
    }
    val background = when (index) {
        0 -> R.drawable.widget_diamond_bg
        1 -> R.drawable.widget_gold_bg
        2 -> R.drawable.widget_silver_bg
        3 -> R.drawable.widget_bronze_bg
        else -> R.drawable.widget_diamond_bg
    }
}