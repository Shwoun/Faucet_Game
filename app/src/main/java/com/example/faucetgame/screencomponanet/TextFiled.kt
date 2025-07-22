package com.example.faucetgame.screencomponanet

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.faucetgame.componanet.LocalDimensions
import com.example.faucetgame.ui.theme.black
import com.example.faucetgame.ui.theme.comla
import com.example.faucetgame.ui.theme.litewihet
import com.example.faucetgame.ui.theme.wihet


@Composable
fun Textfield(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = LocalDimensions.current.sp(16f),
    modifier: Modifier = Modifier.fillMaxWidth(),
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
    )
) {
    val focusManager = LocalFocusManager.current
    val response = LocalDimensions.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text( labelText, fontSize = fontSize, fontWeight = fontWeight) },
        singleLine = true,
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = black,
            unfocusedContainerColor = black,
            unfocusedBorderColor = comla,
            focusedBorderColor = comla,
            focusedLabelColor = litewihet,
            unfocusedLabelColor = litewihet,
            unfocusedTextColor = litewihet,
            focusedTextColor =litewihet
        ),
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(response.dp(12)),
        textStyle = TextStyle(
            fontSize = fontSize,
            fontWeight = FontWeight.W500
        ),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
        ),

    )
}