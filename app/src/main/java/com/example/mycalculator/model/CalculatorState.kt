package com.example.mycalculator.model

import com.example.mycalculator.data.CalculatorOperation

data class CalculatorState(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val operation: CalculatorOperation? = null
)