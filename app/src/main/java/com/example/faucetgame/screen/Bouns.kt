package com.example.faucetgame.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.faucetgame.R
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.green
import com.example.faucetgame.ui.theme.liteblack
import com.example.faucetgame.ui.theme.litewihet
import com.example.faucetgame.ui.theme.wihet
import kotlinx.coroutines.launch

@Preview(showSystemUi = true)
@Composable
fun Bouns() {

    val respons = LocalDimensions.current


    val rewards = listOf(50, 150, 200, 250, 300, 350, 400, 500)
    var claimedIndex by remember { mutableStateOf(-1) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
            .padding(horizontal = respons.dp(8)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            "Daily Reward",
            fontSize = respons.sp(25f),
            fontWeight = FontWeight.W800,
            color = wihet
        )
        Spacer(Modifier.height(respons.dp(8)))
        Text(
            "Claim your daily rewards",
            fontSize = respons.sp(16f),
            fontWeight = FontWeight.W500,
            color = litewihet
        )
        Spacer(Modifier.height(respons.dp(8)))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(respons.dp(14)),
            verticalArrangement = Arrangement.spacedBy(respons.dp(13))
        ) {
            rewards.forEachIndexed { index, coin ->


                Botton(
                    onclick = {

                    },
                    daytext = "Day ${index + 1}",
                    coin = coin,
                    enabled = index == 0,
                    claimed = claimedIndex == index

                )

            }
        }

    }
}


@Composable
fun Botton(
    onclick: () -> Unit,
    daytext: String,
    coin: Int,
    enabled: Boolean = true,
    claimed: Boolean = false
) {
    val respons = LocalDimensions.current
    val scale = remember { Animatable(1f) }
    val coroutineScope = rememberCoroutineScope()

    Button(
        onClick = {
            coroutineScope.launch {
                scale.animateTo(1.1f, animationSpec = tween(100))
                scale.animateTo(1f, animationSpec = tween(100))
            }
            onclick()
        },
        enabled = enabled,
        modifier = Modifier
            .size(height = respons.dp(130), width = respons.dp(110))
            .graphicsLayer(scaleX = scale.value, scaleY = scale.value),
        colors = ButtonDefaults.buttonColors(
            containerColor = when {
                claimed -> wihet
                enabled -> green
                else -> litewihet
            },
            disabledContainerColor = liteblack,
            disabledContentColor = Color.DarkGray
        ),

        shape = RoundedCornerShape(respons.dp(12))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(daytext, fontSize = respons.sp(14f), fontWeight = FontWeight.W900, color = litewihet)
            Image(
                painter = painterResource(id = R.drawable.coin),
                contentDescription = "Coin",
                modifier = Modifier.size(respons.dp(40))
            )
            Text(coin.toString(), fontSize = respons.sp(14f), color = litewihet)
        }
    }
}