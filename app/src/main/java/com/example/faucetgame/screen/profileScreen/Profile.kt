package com.example.faucetgame.screen.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.screencomponanet.Textfield
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.comla

@Preview(showSystemUi = true)
@Composable
fun Profile() {
    val respons = LocalDimensions.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
            .padding(respons.dp(8)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(Modifier.height(respons.dp(20)))
        Card(
            modifier = Modifier.size(respons.dp(200)), shape = RoundedCornerShape(respons.dp(100))

        ) {}
        Spacer(Modifier.height(respons.dp(30)))
        Textfield(value = name, onValueChange = { name = it }, labelText = "Name")
        Textfield(value = email, onValueChange = { email = it }, labelText = "Email")

        Spacer(Modifier.height(respons.dp(70)))

        TextButton(onClick = {}) {
            Column {

                Text("Sing Out", color = comla, fontSize = respons.sp(20f))
                HorizontalDivider(modifier = Modifier.width(respons.dp(78)), color = comla)
            }
        }
    }

}