package com.example.mycalculator.data

sealed class CalculatorOperation(val symbol: String) {
    object Addition: CalculatorOperation("+")
    object Subtraction: CalculatorOperation("-")
    object Multiplication: CalculatorOperation("x")
    object Division: CalculatorOperation("/")
    object Modulo: CalculatorOperation("%")
}
