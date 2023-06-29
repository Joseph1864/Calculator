package com.joew.calculator.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    val buttonTexts = listOf(
        listOf("7", "8", "9", "X"),
        listOf("4", "5,", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("0", ".", " ", "=")
    )


}

@Composable
fun Button(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
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