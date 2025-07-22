package com.example.faucetgame.screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import com.example.faucetgame.R
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.screencomponanet.Textfield
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.comla
import com.example.faucetgame.ui.theme.green
import com.example.faucetgame.ui.theme.litewihet
import com.example.faucetgame.ui.theme.wihet

@Composable
fun Login() {
    val respons = LocalDimensions.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
            .padding(respons.dp(8)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(respons.dp(70)))
        Text(
            "Welcom Back",
            fontSize = respons.sp(40f),
            fontWeight = FontWeight.ExtraBold,
            color = wihet
        )
        Spacer(Modifier.height(respons.dp(20)))
        Text(
            "Login to your account",
            fontSize = respons.sp(19f),
            color = litewihet,
            fontWeight = FontWeight.W500
        )
        Spacer(Modifier.height(respons.dp(20)))
        Textfield(value = email, onValueChange = { email = it }, labelText = "Email")
        Textfield(
            value = password,
            onValueChange = { password = it },
            labelText = "Password",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        Spacer(Modifier.height(respons.dp(20)))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = litewihet,
                        checkedColor = green
                    )

                )
                Text("Remember Me", color = litewihet, fontSize = respons.sp(16f))
            }


            TextButton(onClick = { }) {
                Text(
                    "Forgot Password ?",
                    color = litewihet,
                    fontSize = respons.sp(16f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
        Spacer(Modifier.height(respons.dp(70)))
        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(respons.dp(45)),
            shape = RoundedCornerShape(respons.dp(16)),
            colors = ButtonDefaults.buttonColors(containerColor = green)

        ) {
            Text("Login", fontSize = respons.sp(22f))
        }

        Spacer(Modifier.height(respons.dp(30)))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(respons.dp(19)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                thickness = respons.dp(1),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = respons.dp(8))
            )
            Text(
                " Or continue with ",
                color = litewihet,
                fontSize = respons.sp(15f),
                fontWeight = FontWeight.W900
            )
            HorizontalDivider(
                thickness = respons.dp(1),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = respons.dp(8))
            )
        }
        Spacer(Modifier.height(respons.dp(30)))
        IconButton(onClick = {}) {


            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = null,
                modifier = Modifier.size(respons.dp(50))
            )
        }
        Spacer(Modifier.height(respons.dp(30)))
        TextButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Don't have account?", color = litewihet, fontSize = respons.sp(16f))
            Text(
                " Register",
                color = comla,
                fontSize = respons.sp(19f),
                fontWeight = FontWeight.W600
            )
        }
    }

}