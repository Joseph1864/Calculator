package com.joew.calculator.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joew.calculator.Calculator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.ArithmeticException
import java.text.DecimalFormat

class MainScreenViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenViewState())
    val uiState: StateFlow<MainScreenViewState> = _uiState.asStateFlow()
    val calculator = Calculator()

    fun buttonPressed(input: Char) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    totalExpression = it.totalExpression + input
                )
            }
        }
    }

    fun equalsPressed() {
        try {
            updateView()
        } catch(e: ArithmeticException) {
            undefinedInput()
        }
    }

    fun updateView()  {
        DecimalFormat("#.#####").format(calculator.evaluateExpression(_uiState.value.totalExpression))
    }
    fun undefinedInput() {
        _uiState.update {
            it.copy(
                result = "Undefined"
            )
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