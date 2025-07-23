package com.example.faucetgame.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
            .background(black),
        verticalArrangement = Arrangement.Bottom
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(respons.dp(50)),
            colors = CardDefaults.cardColors(containerColor = comla)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Iconlogo(R.drawable.home)
                Iconlogo(R.drawable.bouns)
                Iconlogo(R.drawable.history)
                Iconlogo(R.drawable.user)
            }
        }

    }

}

@Composable
fun Iconlogo(
    icon: Int
) {
    val respons = LocalDimensions.current
    IconButton(onClick = {}, modifier = Modifier.size(respons.dp(45))) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(respons.dp(35))
        )

    }
}