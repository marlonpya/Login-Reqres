package com.example.loginreqres.ui.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginreqres.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel(), LoginUiAction {
    private val _uiState = MutableLoginUiState()
    val uiState = _uiState

    private val _channel = Channel<LoginUiEvent>()
    val channel: Flow<LoginUiEvent> = _channel.receiveAsFlow()

    init {
        uiState.name = savedStateHandle.get<String>(Routes.Login.name) ?: "not found"
        uiState.email = savedStateHandle.get<String>(Routes.Login.email) ?: "not found"
    }

    override fun onContinue() {
        viewModelScope.launch(Dispatchers.Default) {
            _channel.send(LoginUiEvent.OnContinue(uiState.name, uiState.email))
        }
    }

    override fun onPasswordTyping(value: String) {
        uiState.password = value
    }

    override fun onShowPassword(show: Boolean) {
        uiState.showPassword = show
    }

    override fun onEnableButton() {
        uiState.enableButton = uiState.password.isNotEmpty()
    }
}