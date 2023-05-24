package com.example.mycalculator.ui.screen.other

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycalculator.data.CalculatorAction
import com.example.mycalculator.data.numbers
import com.example.mycalculator.model.CalculatorViewModel
import com.example.mycalculator.ui.screen.CalculatorButton

@Composable
fun NumberScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel
) {
    Column(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
        ) {
            items(numbers) { number ->
                CalculatorButton(
                    symbol = number,
                    onClick = {
                              when(number) {
                                  "." -> { viewModel.onAction(CalculatorAction.Decimal) }
                                  "<-" -> { viewModel.onAction(CalculatorAction.Delete) }
                                  else -> { viewModel.onAction(CalculatorAction.Number(number.toInt())) }
                              }
                    },
                    onLongClick = {
                              if (number == "<-") {
                                  viewModel.onAction(CalculatorAction
                                      .Reset)
                              }
                    },
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}
