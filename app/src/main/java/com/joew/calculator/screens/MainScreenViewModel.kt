package com.joew.calculator.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.DecimalFormat

class MainScreenViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenViewState())
    val uiState: StateFlow<MainScreenViewState> = _uiState.asStateFlow()

    private var operation: Int = 0
    private var operand1: String = ""
    private var operand2: String = ""
    fun buttonPressed(input: String) {
        if (operation == 0) {
            operand1 += input
        } else {
            operand2 += input
        }
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    totalExpression = it.totalExpression + input
                )
            }
        }
    }

    fun additionPressed(input: String) {
        operation = 1
        viewModelScope.launch {
            _uiState.update{
                it.copy(
                    totalExpression = it.totalExpression + input
                )
            }
        }
    }
    fun subtractionPressed(input: String) {
        operation = 2
        viewModelScope.launch {
            _uiState.update{
                it.copy(
                    totalExpression = it.totalExpression + input
                )
            }
        }
    }
    fun multiplicationPressed(input: String) {
        operation = 3
        viewModelScope.launch {
            _uiState.update{
                it.copy(
                    totalExpression = it.totalExpression + input
                )
            }
        }
    }
    fun divisionPressed(input: String) {
        operation = 4
        viewModelScope.launch {
            _uiState.update{
                it.copy(
                    totalExpression = it.totalExpression + input
                )
            }
        }
    }
    fun equalsPressed() {
        val operand1Double = operand1.toDouble()
        val operand2Double = operand2.toDouble()

        var result: Double = 0.0
        val decimalFormat = DecimalFormat("#.###")

        when (operation) {
            1 -> result = operand1Double + operand2Double
            2 -> result = operand1Double - operand2Double
            3 -> result = operand1Double * operand2Double
            4 -> result = operand1Double / operand2Double
        }
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    result = decimalFormat.format(result).toString()
                )
            }
        }
    }

    fun deleteInput() = viewModelScope.launch {
        _uiState.update {
            it.copy(
                totalExpression = it.totalExpression.dropLast(1)
            )
        }
    }

    fun clearInput() {
        operation = 0
        operand1 = ""
        operand2 = ""

        viewModelScope.launch {
            _uiState.update{
                it.copy(
                    totalExpression = "", result = ""
                )
            }
        }
    }
}

data class MainScreenViewState(
    val totalExpression: String = "",
    val result: String = ""
)