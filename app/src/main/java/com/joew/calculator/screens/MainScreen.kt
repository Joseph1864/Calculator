package com.joew.calculator.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "ABC",
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
                    .horizontalScroll(rememberScrollState()),
                fontSize = 36.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 2
            )
            Text(
                text = "ABC",
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
                    .horizontalScroll(rememberScrollState()),
                fontSize = 72.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 2
            )
            Row() {
                CalculatorButton(
                    text = "AC",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                    text = "DEL",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
                CalculatorButton(
                    text = "/",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
            }
            Row() {
                CalculatorButton(
                    text = "7",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                    text = "8",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                        text = "9",
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                onClick = {

                    }
                )
                CalculatorButton(
                    text = "X",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
            }
            Row() {
                CalculatorButton(
                    text = "4",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                    text = "5",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                    text = "6",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                    text = "-",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
            }
            Row() {
                CalculatorButton(
                    text = "1",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                    text = "2",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                    text = "3",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                    text = "+",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
            }
            Row() {
                CalculatorButton(
                    text = "0",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                CalculatorButton(
                    text = ".",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
                CalculatorButton(
                    text = "=",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    onClick = {

                    }
                )
            }
        }
    }

}

