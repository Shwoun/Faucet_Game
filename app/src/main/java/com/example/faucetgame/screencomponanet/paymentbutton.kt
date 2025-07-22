package com.example.faucetgame.screencomponanet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.ui.theme.green
import com.example.faucetgame.ui.theme.litewihet

@Composable
fun Payment_Button(
    imageresoc: Int,
    label: String,
    isSelected: Boolean,
    onclick: () -> Unit,
    modifier: Modifier = Modifier

) {
    val respons = LocalDimensions.current
    val bgColor = if (isSelected) green else litewihet

    Button(
        onClick = onclick,
        modifier = modifier, // ✅ external modifier used here
        shape = RoundedCornerShape(respons.dp(6)),
        colors = ButtonDefaults.buttonColors(containerColor = bgColor),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = imageresoc),
                contentDescription = null,
                modifier = Modifier
                    .size(respons.dp(110))
//                    .height(110.dp)
//                    .width(110.dp) // ✅ internal fixed size for image
            )

            Text(label, fontWeight = FontWeight.W800)
        }
    }
}