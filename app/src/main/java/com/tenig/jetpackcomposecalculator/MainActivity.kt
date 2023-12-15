package com.tenig.jetpackcomposecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tenig.jetpackcomposecalculator.ui.CalculatorScreen
import com.tenig.jetpackcomposecalculator.presentation.CalculatorViewModel
import com.tenig.jetpackcomposecalculator.ui.theme.JetpackComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCalculatorTheme {
            }
        }
    }
}
