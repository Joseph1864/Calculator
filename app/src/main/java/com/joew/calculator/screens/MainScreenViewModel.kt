package com.joew.calculator.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joew.calculator.Calculator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.ArithmeticException
import java.lang.NumberFormatException
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    calculator: Calculator
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenViewState())
    val uiState: StateFlow<MainScreenViewState> = _uiState.asStateFlow()

    fun buttonPressed(input: Char) {
        when (_uiState.value.result) {
            "Undefined" ->
            {
                clearInput()
                _uiState.update {
                    it.copy(
                        totalExpression = it.totalExpression + input
                    )
                }
            }
            "" ->
                _uiState.update {
                    it.copy(
                        totalExpression = it.totalExpression + input
                    )
                }
            else ->
                if (input == '+' || input == '-' || input == 'X' || input == '/') {
                    _uiState.update {
                        it.copy(
                            totalExpression = it.result + input
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            totalExpression = input.toString()
                        )
                    }
                }
        }
        _uiState.update {
            it.copy(
                result = ""
            )
        }
    }

    fun equalsPressed() {
        try {
            updateView()
        } catch(e: Exception) {
            if (e is ArithmeticException || e is NumberFormatException) {
                undefinedInput()
            }
        }
    }

    private fun updateView()  {
        _uiState.update {
            it.copy(
                result = DecimalFormat("#.#####").format(calculator.evaluateExpression(_uiState.value.totalExpression))
            )
        }
    }
    private fun undefinedInput() {
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
        _uiState.update{
            it.copy(
                totalExpression = "", result = ""
            )
        }
    }
}

data class MainScreenViewState(
    val totalExpression: String = "",
    val result: String = ""
)