package com.example.faucetgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.faucetgame.bar.Bottombar
import com.example.faucetgame.componanet.ProvideResponsiveDimensions
import com.example.faucetgame.componanet.Statusbar
import com.example.faucetgame.screen.profileScreen.Mainprofile
import com.example.faucetgame.screen.profileScreen.Payment_Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Statusbar()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProvideResponsiveDimensions {
                        Bottombar()
                    }
                }

        }
    }
}

