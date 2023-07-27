package com.joew.calculator.screens


import androidx.lifecycle.ViewModel
import com.joew.calculator.Calculator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.lang.ArithmeticException
import java.lang.NumberFormatException
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val calculator: Calculator
) : ViewModel() {

    private val _uiState = MutableStateFlow<ViewState>(ViewState.Content())
    val uiState: StateFlow<ViewState> = _uiState.asStateFlow()

    fun buttonPressed(input: Char) {
        when(val currentUiState = uiState.value) {
            is ViewState.Undefined -> ViewState.Content(
                totalExpression = input.toString()
            )
            is ViewState.Content -> {
                when {
                    currentUiState.result.isBlank() -> blankResult(input = input, state = currentUiState)
                    "+-/X".contains(input) -> operationInput(input = input, state = currentUiState)
                    else -> blankResult(input = input, state = currentUiState)
                }
            }
        }
    }

    fun equalsPressed() {
        try {
            updateView()
        } catch (e: ArithmeticException) {
            undefinedInput()
        } catch (e: NumberFormatException) {
            undefinedInput()
        }
    }

    private fun updateView() = _uiState.update {
        when (it) {
            is ViewState.Undefined -> it
            is ViewState.Content -> it.copy(
                result = DecimalFormat("#.#####").format(calculator.evaluateExpression(it.totalExpression))
            )
        }
    }

    private fun blankResult(input: Char, state: ViewState.Content) = _uiState.update {
        state.copy(
            totalExpression = state.totalExpression + input
        )
    }

    private fun operationInput(input:Char, state: ViewState.Content) = _uiState.update{
        state.copy(
            totalExpression = state.result + input,
            result = ""
        )
    }

    fun deleteInput() = _uiState.update {
        when (it) {
            is ViewState.Undefined -> ViewState.Content()
            is ViewState.Content -> it.copy(
                totalExpression = it.totalExpression.dropLast(1),
            )
        }
    }

    fun clearInput() = _uiState.update {
        ViewState.Content(
            totalExpression = "",
            result = ""
        )
    }

    private fun undefinedInput() = _uiState.update { ViewState.Undefined }
}

sealed class ViewState {

    data class Content(
        val totalExpression: String = "",
        val result: String = ""
    ) : ViewState()

    object Undefined : ViewState()
}
