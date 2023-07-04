package com.joew.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.joew.calculator.screens.MainScreen
import com.joew.calculator.screens.MainScreenViewModel
import com.joew.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel by viewModels<MainScreenViewModel>()
                MainScreen(viewModel = viewModel)
            }
        }
    }
}

