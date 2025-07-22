package com.example.faucetgame.screen.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.faucetgame.R
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.liteblack
import com.example.faucetgame.ui.theme.litewihet
import com.example.faucetgame.ui.theme.read
import com.example.faucetgame.ui.theme.wihet


@Composable
fun Mainprofile() {
    val respons = LocalDimensions.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
            .padding(respons.dp(8))
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(respons.dp(150)),
                shape = RoundedCornerShape(respons.dp(100))
            ) { }
            Spacer(Modifier.width(respons.dp(3)))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    "MD Shwoun Hossen",
                    color = litewihet,
                    fontSize = respons.sp(23f),
                    fontWeight = FontWeight.W500
                )
                Text("hossenhossen6378@gmail.com", color = litewihet, fontSize = respons.sp(13f))
                Spacer(Modifier.height(respons.dp(20)))
                Button(
                    onClick = {},
                    modifier = Modifier.width(respons.dp(170)),
                    shape = RoundedCornerShape(respons.dp(8)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = read,
                        contentColor = litewihet
                    )
                ) { Text("Edit Profile") }

            }
        }
        Spacer(Modifier.height(respons.dp(20)))
        Botton(R.drawable.wallet, "Wallet")
        Spacer(Modifier.height(respons.dp(12)))
        Botton(R.drawable.podium, "LeaderBoard")
        Spacer(Modifier.height(respons.dp(12)))
        Botton(R.drawable.help, "Help Center")
        Spacer(Modifier.height(respons.dp(12)))
        Botton(R.drawable.support, "Contactus")
        Spacer(Modifier.height(respons.dp(12)))
        Botton(R.drawable.policyprivacy, "Privacy Policy")
        Spacer(Modifier.height(respons.dp(12)))
        Botton(R.drawable.logout , " Log Out", tint = read)
    }

}


@Composable
fun Botton(

    Icon: Int,
    Text: String ,
    tint : Color = wihet
) {
    val respons = LocalDimensions.current
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(respons.dp(50)),
        shape = RoundedCornerShape(respons.dp(8)),
        colors = ButtonDefaults.buttonColors(containerColor = liteblack)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = Icon),
                    tint = tint,
                    contentDescription = null,
                    modifier = Modifier

                        .size(respons.dp(30))
                )
                Spacer(Modifier.width(respons.dp(20)))
                Text(
                    text = Text,
                    fontSize = respons.sp(20f)
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .rotate(180f)
                    .size(respons.dp(25))
            )
        }
    }

}