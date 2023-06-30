package com.joew.calculator.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenViewState())
    val uiState: StateFlow<MainScreenViewState> = _uiState.asStateFlow()

    fun buttonPressed(input: String) = viewModelScope.launch {
        _uiState.update {
            it.copy(
                calculationInput = it.calculationInput + input
            )
        }
    }

    fun deleteInput() = viewModelScope.launch {
        _uiState.update {
            it.copy(
                calculationInput = it.calculationInput.dropLast(1)
            )
        }
    }

    fun clearInput() = viewModelScope.launch {
        _uiState.update{
            it.copy(
                calculationInput = ""
            )
        }
    }
}

data class MainScreenViewState(
    val calculationInput: String = "",
)