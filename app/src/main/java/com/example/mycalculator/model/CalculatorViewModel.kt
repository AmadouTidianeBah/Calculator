package com.example.mycalculator.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mycalculator.data.CalculatorAction
import com.example.mycalculator.data.CalculatorOperation

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Calculate -> onCalculateClicked()
            is CalculatorAction.Decimal -> onDecimalClicked()
            is CalculatorAction.Delete -> onDeleteClicked()
            is CalculatorAction.Number -> onNumberClicked(action.number)
            is CalculatorAction.Operation -> onOperationClicked(action.operation)
            is CalculatorAction.Reset -> state = CalculatorState()
        }
    }

    private fun onCalculateClicked() {
        val firstNumber = state.firstNumber.toDoubleOrNull()
        val secondNumber = state.secondNumber.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Addition -> firstNumber + secondNumber
                is CalculatorOperation.Division -> firstNumber / secondNumber
                is CalculatorOperation.Modulo -> firstNumber % secondNumber
                is CalculatorOperation.Multiplication -> firstNumber * secondNumber
                is CalculatorOperation.Subtraction -> firstNumber - secondNumber
                null -> return
            }
            state = state.copy(
                firstNumber = result.toString().take(MAX_NUM_LENGTH),
                secondNumber = "",
                operation = null
            )
        }
        return
    }

    private fun onDecimalClicked() {
        if (state.operation == null &&
            !state.firstNumber.contains(".") &&
            state.firstNumber.isNotBlank()) {
            state = state.copy(firstNumber = state.firstNumber + ".")
            return
        }
        if (!state.secondNumber.contains(".") &&
            state.secondNumber.isNotBlank()) {
            state = state.copy(secondNumber = state.secondNumber + ".")
        }
    }

    private fun onDeleteClicked() {
        when {
            state.secondNumber.isNotBlank() -> state = state.copy(secondNumber = state.secondNumber.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
            state.firstNumber.isNotBlank() -> state = state.copy(firstNumber = state.firstNumber.dropLast(1))
        }
    }

    private fun onNumberClicked(number: Int) {
        if (state.operation == null) {
            if (state.firstNumber.length >= MAX_NUM_LENGTH) return
            state = state.copy(firstNumber = state.firstNumber + number)
            return
        } else {
            if (state.secondNumber.length >= MAX_NUM_LENGTH) return
            state = state.copy(secondNumber = state.secondNumber + number)
        }
    }

    private fun onOperationClicked(operation: CalculatorOperation) {
        when {
            state.secondNumber.isNotBlank() -> {
                onCalculateClicked()
                state = state.copy(operation = operation)
                return
            }
            state.firstNumber.isNotBlank() -> {
                state = state.copy(operation = operation)
            }
        }
    }
    companion object {
        private const val MAX_NUM_LENGTH = 9
    }
}