package com.example.mycalculator.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.MyCalculatorApp
import com.example.mycalculator.data.CalculatorAction
import com.example.mycalculator.data.CalculatorOperation
import com.example.mycalculator.model.CalculatorState
import com.example.mycalculator.ui.theme.MyCalculatorTheme

@Composable
fun CalculatorScreen(
    calculatorState: CalculatorState,
    modifier: Modifier = Modifier,
    onAction: (CalculatorAction) -> Unit
) {
    Box(
        modifier = modifier.background(Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = calculatorState.firstNumber +
                        (calculatorState.operation?.symbol ?: "") +
                        calculatorState.secondNumber,
                fontSize = 52.sp,
                textAlign = TextAlign.End,
                maxLines = 2,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            ButtonRow(
                symbol1 = "AC",
                onClick1 = { onAction(CalculatorAction.Reset) },
                symbol2 = "Del",
                onClick2 = { onAction(CalculatorAction.Delete) },
                symbol3 = "%",
                onClick3 = { onAction(CalculatorAction.Operation(CalculatorOperation.Modulo)) },
                symbol4 = "/",
                onClick4 = { onAction(CalculatorAction.Operation(CalculatorOperation.Division)) })
            ButtonRow(
                symbol1 = "9",
                onClick1 = { onAction(CalculatorAction.Number(9)) },
                symbol2 = "8",
                onClick2 = { onAction(CalculatorAction.Number(8)) },
                symbol3 = "7",
                onClick3 = { onAction(CalculatorAction.Number(7)) },
                symbol4 = "x",
                onClick4 = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiplication)) })
            ButtonRow(
                symbol1 = "6",
                onClick1 = { onAction(CalculatorAction.Number(6)) },
                symbol2 = "5",
                onClick2 = { onAction(CalculatorAction.Number(5)) },
                symbol3 = "4",
                onClick3 = { onAction(CalculatorAction.Number(4)) },
                symbol4 = "-",
                onClick4 = { onAction(CalculatorAction.Operation(CalculatorOperation.Subtraction)) })
            ButtonRow(
                symbol1 = "3",
                onClick1 = { onAction(CalculatorAction.Number(3)) },
                symbol2 = "2",
                onClick2 = { onAction(CalculatorAction.Number(2)) },
                symbol3 = "1",
                onClick3 = { onAction(CalculatorAction.Number(1)) },
                symbol4 = "+",
                onClick4 = { onAction(CalculatorAction.Operation(CalculatorOperation.Addition)) })
            ButtonRow(
                symbol1 = "0",
                onClick1 = { onAction(CalculatorAction.Number(0)) },
                symbol2 = ".",
                onClick2 = { onAction(CalculatorAction.Decimal) },
                symbol3 = "ATB",
                onClick3 = { /*TODO*/ },
                symbol4 = "=",
                onClick4 = { onAction(CalculatorAction.Calculate) })
        }
    }
}

@Composable
fun ButtonRow(
    symbol1: String,
    onClick1: () -> Unit,
    symbol2: String,
    onClick2: () -> Unit,
    symbol3: String,
    onClick3: () -> Unit,
    symbol4: String,
    onClick4: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CalculatorButton(
            symbol = symbol1,
            onClick = onClick1,
            modifier = Modifier.weight(1f)
        )
        CalculatorButton(
            symbol = symbol2,
            onClick = onClick2,
            modifier = Modifier.weight(1f)
        )
        CalculatorButton(
            symbol = symbol3,
            onClick = onClick3,
            modifier = Modifier.weight(1f)
        )
        CalculatorButton(
            symbol = symbol4,
            onClick = onClick4,
            modifier = Modifier.weight(1f)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCal() {
    MyCalculatorTheme {
        MyCalculatorApp()
    }
}