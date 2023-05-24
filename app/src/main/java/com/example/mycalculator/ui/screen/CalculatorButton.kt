package com.example.mycalculator.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    symbol: String,
    onClick: () -> Unit,
    onLongClick: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)
            .pointerInput(true) {
                detectTapGestures(
                    onPress = { onClick() },
                    onLongPress = { onLongClick() }
                )
            }
            .background(Color.DarkGray)
            .size(50.dp)
    ) {
        Text(
            text = symbol,
            fontSize = 28.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CalculatorButton(symbol = "5", onClick = { /*TODO*/ })
}