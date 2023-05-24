package com.example.mycalculator.ui.screen.other

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.model.CalculatorState
import com.example.mycalculator.model.CalculatorViewModel

@Composable
fun OtherCalculatorUi(
    calculatorState: CalculatorState,
    viewModel: CalculatorViewModel,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = calculatorState.firstNumber + " " +
                        (calculatorState.operation?.symbol ?: "") + " " +
                        calculatorState.secondNumber,
                fontSize = 52.sp,
                textAlign = TextAlign.End,
                maxLines = 2,
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                NumberScreen(modifier = Modifier.weight(2f), viewModel = viewModel)
                Spacer(Modifier.width(8.dp))
                OperationScreen(modifier = Modifier.weight(1f), viewModel = viewModel)
            }
        }
    }
}
