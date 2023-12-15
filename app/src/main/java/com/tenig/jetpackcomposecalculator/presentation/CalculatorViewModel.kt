package com.tenig.jetpackcomposecalculator.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    companion object {
        val MAX_NUMBER_LENGTH = 8
    }

    var state by mutableStateOf(CalculatorState())
        private set

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.EnteredNumber -> enteredNumber(event.number)
            is CalculatorEvent.Decimal -> enteredDecimal()
            is CalculatorEvent.Operation -> enteredOperation(event.operation)
            is CalculatorEvent.Calculate -> performCalculation()
            is CalculatorEvent.Delete -> performDeletion()
            is CalculatorEvent.Clear -> clearDisplay()

        }
    }


    private fun enteredNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUMBER_LENGTH) {
                return
            }
            state = state.copy(number1 = state.number1 + number)
        } else {
            if (state.number2.length >= MAX_NUMBER_LENGTH) {
                return
            }
            state = state.copy(number2 = state.number2 + number)
        }
    }

    private fun enteredDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2 + ".")
        }

    }

    private fun enteredOperation(operation: CalculatorOperations) {
        state = state.copy(operation = operation)
    }

    private fun performDeletion() {
        if ( state.number2.isNotBlank()){
            state = state.copy(number2 = state.number2.dropLast(1))
            return
        }
        if (state.operation != null){
            state = state.copy(operation = null)
            return
        }
       if ( state.number1.isNotBlank()){
           state = state.copy(number1 = state.number1.dropLast(1))
       }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        val operation = state.operation
        if (number1 != null && number2 != null) {
            val result = when (operation) {
                is CalculatorOperations.Add -> number1 + number2
                is CalculatorOperations.Subtract -> number1 - number2
                is CalculatorOperations.Multiply -> number1 * number2
                is CalculatorOperations.Divide -> number1 / number2
                null -> return
            }

            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null)
        }
    }

    private fun clearDisplay() {
        state = CalculatorState()
    }

}