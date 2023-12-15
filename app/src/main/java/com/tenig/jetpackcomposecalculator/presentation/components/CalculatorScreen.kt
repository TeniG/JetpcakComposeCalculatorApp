package com.tenig.jetpackcomposecalculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenig.jetpackcomposecalculator.presentation.CalculatorEvent
import com.tenig.jetpackcomposecalculator.presentation.CalculatorOperations
import com.tenig.jetpackcomposecalculator.presentation.CalculatorViewModel
import com.tenig.jetpackcomposecalculator.ui.theme.GreyShade
import com.tenig.jetpackcomposecalculator.ui.theme.LightGray
import com.tenig.jetpackcomposecalculator.ui.theme.Orange

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp,
    calcViewModel: CalculatorViewModel
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            DisplayArea(calcViewModel)
            FirstRow(buttonSpacing, calcViewModel)
            SecondRow(buttonSpacing, calcViewModel)
            ThirdRow(buttonSpacing, calcViewModel)
            FourthRow(buttonSpacing, calcViewModel)
            FifthRow(buttonSpacing, calcViewModel)
        }
    }
}

@Composable
private fun DisplayArea(calcViewModel: CalculatorViewModel) {
    Box(modifier =  Modifier
        .padding( 8.dp)

        ) {
        Text(
            text = calcViewModel.state.number1 + (calcViewModel.state.operation?.symbol
                ?: "") + calcViewModel.state.number2,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding( 32.dp),
            fontSize = 80.sp,
            fontWeight = FontWeight.Light,
            color = Color.White,
            maxLines = 2,
        )
    }

}

@Composable
private fun FirstRow(buttonSpacing: Dp, calcViewModel: CalculatorViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            text = "AC",
            modifier = Modifier
                .aspectRatio(2f)
                .weight(2f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.Clear)
        }
        CalculatorButton(
            text = "Del",
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.Delete)
        }
        CalculatorButton(
            text = "/",
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(color = Orange)
        ) {
            calcViewModel.onEvent(CalculatorEvent.Operation(CalculatorOperations.Divide))
        }
    }
}

@Composable
private fun SecondRow(buttonSpacing: Dp, calcViewModel: CalculatorViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            text = "7",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(7))
        }
        CalculatorButton(
            text = "8",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(8))
        }
        CalculatorButton(
            text = "9",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(9))
        }
        CalculatorButton(
            text = "x",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Orange)
        ) {
            calcViewModel.onEvent(CalculatorEvent.Operation(CalculatorOperations.Multiply))
        }
    }
}

@Composable
private fun ThirdRow(buttonSpacing: Dp, calcViewModel: CalculatorViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            text = "4",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(4))

        }
        CalculatorButton(
            text = "5",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(5))

        }
        CalculatorButton(
            text = "6",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(6))

        }
        CalculatorButton(
            text = "-",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Orange)
        ) {
            calcViewModel.onEvent(CalculatorEvent.Operation(CalculatorOperations.Subtract))

        }
    }
}


@Composable
private fun FourthRow(buttonSpacing: Dp, calcViewModel: CalculatorViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            text = "1",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(1))
        }
        CalculatorButton(
            text = "2",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(2))
        }
        CalculatorButton(
            text = "3",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(3))
        }
        CalculatorButton(
            text = "+",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Orange)
        ) {
            calcViewModel.onEvent(CalculatorEvent.Operation(CalculatorOperations.Add))
        }
    }
}


@Composable
private fun FifthRow(buttonSpacing: Dp, calcViewModel: CalculatorViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            text = "0",
            modifier = Modifier
                .weight(2f)
                .aspectRatio(2f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.EnteredNumber(0))
        }
        CalculatorButton(
            text = ".",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = LightGray)
        ) {
            calcViewModel.onEvent(CalculatorEvent.Decimal)
        }
        CalculatorButton(
            text = "=",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(color = Orange)
        ) {
            calcViewModel.onEvent(CalculatorEvent.Calculate)
        }

    }
}
