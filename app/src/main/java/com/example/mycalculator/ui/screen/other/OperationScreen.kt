package com.example.mycalculator.ui.screen.other

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.example.mycalculator.data.CalculatorAction
import com.example.mycalculator.data.CalculatorOperation
import com.example.mycalculator.model.CalculatorViewModel
import com.example.mycalculator.ui.screen.CalculatorButton

@Composable
fun OperationScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel
) {
    val constraintSet = constraintSet()

    ConstraintLayout(
        constraintSet = constraintSet, modifier = modifier
            .fillMaxWidth()
    ) {
        val operationPadding = 4.dp
        CalculatorButton(
            symbol = "%",
            onClick = {
                viewModel.onAction(
                    CalculatorAction.Operation(
                        CalculatorOperation.Modulo
                    )
                )
            },
            modifier = Modifier
                .layoutId("modulo")
                .padding(operationPadding)
        )
        CalculatorButton(
            symbol = "/",
            onClick = {
                viewModel.onAction(
                    CalculatorAction.Operation(
                        CalculatorOperation.Division
                    )
                )
            },
            modifier = Modifier
                .layoutId("division")
                .padding(operationPadding)
        )
        CalculatorButton(
            symbol = "+",
            onClick = { viewModel.onAction(
                CalculatorAction.Operation(
                    CalculatorOperation.Addition)
            ) },
            modifier = Modifier
                .layoutId("plus")
                .padding(operationPadding)
        )
        CalculatorButton(
            symbol = "-",
            onClick = {
                viewModel.onAction(
                    CalculatorAction.Operation(
                        CalculatorOperation.Subtraction
                    )
                )
            },
            modifier = Modifier
                .layoutId("minus")
                .padding(operationPadding)
        )
        CalculatorButton(
            symbol = "x",
            onClick = {
                viewModel.onAction(
                    CalculatorAction.Operation(
                        CalculatorOperation.Multiplication
                    )
                )
            },
            modifier = Modifier
                .layoutId("multiplication")
                .padding(operationPadding)
        )
        CalculatorButton(
            symbol = "=",
            onClick = {
                viewModel.onAction(
                    CalculatorAction.Calculate
                )
            },
            modifier = Modifier
                .layoutId("equal")
                .padding(operationPadding)
        )

    }
}

fun constraintSet(): ConstraintSet {
    return ConstraintSet {
        val modulo = createRefFor("modulo")
        val division = createRefFor("division")
        val plus = createRefFor("plus")
        val minus = createRefFor("minus")
        val multiplication = createRefFor("multiplication")
        val equal = createRefFor("equal")

        constrain(modulo) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }
        constrain(division) {
            top.linkTo(parent.top)
            start.linkTo(modulo.end)
        }
        constrain(plus) {
            top.linkTo(modulo.bottom)
            start.linkTo(parent.start)
            bottom.linkTo(multiplication.bottom)
            height = Dimension.fillToConstraints
        }
        constrain(minus) {
            top.linkTo(division.bottom)
            start.linkTo(plus.end)
        }
        constrain(multiplication) {
            top.linkTo(minus.bottom)
            start.linkTo(plus.end)
        }
        constrain(equal) {
            top.linkTo(plus.bottom)
            start.linkTo(parent.start)
            end.linkTo(multiplication.end)
            width = Dimension.fillToConstraints
        }
    }
}

