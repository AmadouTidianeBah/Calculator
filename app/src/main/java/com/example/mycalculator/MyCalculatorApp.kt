package com.example.mycalculator

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycalculator.model.CalculatorState
import com.example.mycalculator.model.CalculatorViewModel
import com.example.mycalculator.ui.screen.other.OtherCalculatorUi

@Composable
fun MyCalculatorApp(
    viewModel: CalculatorViewModel = viewModel(),
    calculatorState: CalculatorState = viewModel.state
) {
    //CalculatorScreen(calculatorState = calculatorState, onAction = viewModel::onAction)
    OtherCalculatorUi(calculatorState = calculatorState, viewModel = viewModel)
}