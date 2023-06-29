package com.joew.calculator.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable { onClick() }
            .then(modifier)
    ) {
        Text(
            text = text,
            fontSize = 36.sp,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}