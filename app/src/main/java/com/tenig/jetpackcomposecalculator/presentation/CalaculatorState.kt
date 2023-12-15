package com.tenig.jetpackcomposecalculator.presentation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperations? = null,
)