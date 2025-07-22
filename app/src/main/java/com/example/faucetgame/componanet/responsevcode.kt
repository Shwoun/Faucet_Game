package com.example.faucetgame.componanet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Dimensions(val scaleFactor: Float) {
    fun dp(value: Int): Dp = (value * scaleFactor).dp
    fun dp(value: Float): Dp = (value * scaleFactor).dp
    fun sp(value: Float): TextUnit = (value * scaleFactor).sp
}

val LocalDimensions = compositionLocalOf { Dimensions(1f) }


@Composable
fun ProvideResponsiveDimensions(content: @Composable () -> Unit) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    val scaleFactor = when {
        screenWidth <= 320 -> 0.85f
        screenWidth <= 375 -> 0.95f
        screenWidth <= 411 -> 1f
        screenWidth <= 480 -> 1.1f
        else -> 1.2f
    }

    CompositionLocalProvider(
        LocalDimensions provides Dimensions(scaleFactor)
    ) {
        content()
    }
}