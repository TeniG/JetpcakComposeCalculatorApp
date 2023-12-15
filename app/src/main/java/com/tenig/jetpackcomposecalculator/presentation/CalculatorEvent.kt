package com.tenig.jetpackcomposecalculator.presentation


sealed class CalculatorEvent{
    data class EnteredNumber(val number: Int) : CalculatorEvent()
    data class Operation(val operation: CalculatorOperations) : CalculatorEvent()
    object Delete : CalculatorEvent()
    object Clear : CalculatorEvent()
    object Calculate : CalculatorEvent()
    object Decimal : CalculatorEvent()

}



