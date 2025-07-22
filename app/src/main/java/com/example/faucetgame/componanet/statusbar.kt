package com.example.faucetgame.componanet

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.litewihet
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun Statusbar() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false
    val view = LocalView.current
    val window = (view.context as? Activity)?.window

    SideEffect {
//        window?.statusBarColor = android.graphics.Color.BLACK
        systemUiController.isStatusBarVisible = false
        WindowCompat.setDecorFitsSystemWindows( window!!,true)
        window.setBackgroundDrawableResource(android.R.color.black)

        systemUiController.setStatusBarColor(
            color = black,
            darkIcons = useDarkIcons
        )
        systemUiController.setNavigationBarColor(
            color = black,
            darkIcons = false
        )
    }



}