package com.example.faucetgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.faucetgame.componanet.ProvideResponsiveDimensions
import com.example.faucetgame.componanet.Statusbar
import com.example.faucetgame.screen.Bouns
import com.example.faucetgame.screen.history.HistoryScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Statusbar()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProvideResponsiveDimensions {
                        HistoryScreen()
                    }
                }

        }
    }
}



