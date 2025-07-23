package com.example.faucetgame.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faucetgame.R
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.green
import com.example.faucetgame.ui.theme.wihet

@Preview(showSystemUi = true)
@Composable
fun Topbar() {
    val respons = LocalDimensions.current
    Row(
        modifier = Modifier.fillMaxWidth().background(black),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = wihet
            )
        }

        Text("Home", color = wihet)

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "67821",
                fontSize = respons.sp(15f),
                color = green,
                fontWeight = FontWeight.ExtraBold
            )
            Image(
                painter = painterResource(id = R.drawable.coin),
                contentDescription = null,
                modifier = Modifier.size(respons.dp(25))
            )
            Spacer(modifier = Modifier.width(respons.dp(4)))
        }
    }

}