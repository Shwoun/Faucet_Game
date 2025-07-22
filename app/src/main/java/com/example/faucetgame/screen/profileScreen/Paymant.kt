package com.example.faucetgame.screen.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.faucetgame.R
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.screencomponanet.Payment_Button
import com.example.faucetgame.screencomponanet.Textfield
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.green
import com.example.faucetgame.ui.theme.litewihet
import com.example.faucetgame.ui.theme.wihet
import kotlin.collections.get

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun Payment_Screen() {
    val respons = LocalDimensions.current

    var selected by remember { mutableStateOf<String?>(null) }
    var coin by remember { mutableStateOf("") }
    var walletaddress by remember { mutableStateOf("") }


    val coinValue = coin.toLongOrNull()

    val isFormValid = selected != null &&
            coinValue != null &&
            walletaddress.isNotBlank() &&
            (
                    (selected == "Nagad" && coinValue >= 2000) ||
                            (selected != "Nagad" && coinValue >= 500)
                    )


    val rateMap = mapOf(
        "Usdt" to 100000.0,    // 1000 coin = 1 USDT
        "Trx" to 28000.0,      // 500 coin = 1 TRX
        "Bch" to 50300000.0,     // 2000 coin = 1 BCH
        "Nagad" to 1000.0    // 1000 coin = 1 BDT (Nagad)
    )
    val coinAmount = coin.toDoubleOrNull() ?: 0.0
    val rate = rateMap[selected] ?: 1.0
    val converteds = coinAmount / rate

    val converted = when (selected) {
        "Nagad" -> "%.2f BDT".format(converteds)
        "Usdt", "Trx", "Bch" -> "%.8f $selected".format(converteds)
        else -> ""
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
            .padding(horizontal = respons.dp(8))
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Select Payment Method",
            color = litewihet,
            fontSize = respons.sp(20f),
            fontWeight = FontWeight.W500
        )
        Spacer(Modifier.height(respons.dp(2)))
        Text("Minimum payout 500 coine", color = litewihet, fontSize = respons.sp(16f))
        Spacer(Modifier.height(respons.dp(16)))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(respons.dp(14)),
            verticalArrangement = Arrangement.spacedBy(respons.dp(13))
        ) {


            Payment_Button(
                R.drawable.nagad,
                label = "Nagad",
                selected == "Nagad",
                onclick = { selected = "Nagad" }, modifier = Modifier
                    .height(respons.dp(150))
                    .width(respons.dp(110))
            )
            Payment_Button(
                R.drawable.usdt,
                "USDT",
                selected == "Usdt",
                onclick = { selected = "Usdt" }, modifier = Modifier
                    .height(respons.dp(150))
                    .width(respons.dp(110))
            )
            Payment_Button(
                R.drawable.bitcoincash,
                "BCH",
                selected == "Bch",
                onclick = { selected = "Bch" }, modifier = Modifier
                    .height(respons.dp(150))
                    .width(respons.dp(110))
            )
            Payment_Button(
                R.drawable.trx,
                "TRX",
                selected == "Trx",
                onclick = { selected = "Trx" },
                modifier = Modifier
                    .height(respons.dp(150))
                    .width(respons.dp(110))
            )

        }
        if (selected == "Nagad") {
            Spacer(modifier = Modifier.height(respons.dp(8)))
            Text(
                text = "⚠ Minimum payout 30000 coin for Nagad",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = respons.sp(14f)
            )
        }
        if (selected != null && coin.isNotBlank()) {
            Spacer(modifier = Modifier.height(respons.dp(8)))
            Text(
                text = "You will receive: $converted",
                fontSize = respons.sp(15f),
                fontWeight = FontWeight.W500,
                color = litewihet
            )
        }

        Textfield(
            value = coin,
            onValueChange = { coin = it },
            labelText = "Amount",
            fontWeight = FontWeight.W500,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )

        Spacer(Modifier.height(respons.dp(12)))
        Textfield(
            value = walletaddress,
            onValueChange = { walletaddress = it },
            labelText = "Wallet Address",
            fontWeight = FontWeight.W500,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            )
        )


        Spacer(Modifier.height(respons.dp(30)))
        Button(
            onClick = {

            },
            enabled = isFormValid,
            modifier = Modifier

                .fillMaxWidth(0.7f)
                .height(respons.dp(48)),
            shape = RoundedCornerShape(respons.dp(12)),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFormValid) green else litewihet,
                contentColor = wihet
            )
        ) {
            Text("Withdraw", fontSize = respons.sp(16f))
        }


    }

}