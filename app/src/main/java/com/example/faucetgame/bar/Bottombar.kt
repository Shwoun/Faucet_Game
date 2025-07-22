package com.example.faucetgame.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faucetgame.R
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.comla

@Preview(showSystemUi = true)
@Composable
fun Bottombar() {
    val respons = LocalDimensions.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(respons.dp(70)),
            colors = CardDefaults.cardColors(containerColor = comla)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {}){
                    Icon(painter = painterResource(R.drawable.home),contentDescription = null)
                }
            }
        }

    }

}