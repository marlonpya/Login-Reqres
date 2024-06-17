package com.example.loginreqres.presentation.signup

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
class SignUpViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel(), SignUpUiAction {

    private val _uiState = MutableSignUpUiState()
    val uiState = _uiState

    private val _channel = Channel<SignUpUiEvent>()
    val channel: Flow<SignUpUiEvent> = _channel.receiveAsFlow()

    init {
        uiState.email = savedStateHandle.get<String>(Routes.SignUp.email) ?: "not found"
    }

    override fun onAgree() {
        viewModelScope.launch(Dispatchers.Default) {
            _channel.send(SignUpUiEvent.OnAgree(uiState.name, uiState.email))
        }
    }

    override fun onNameTyping(value: String) {
        uiState.name = value
    }

    override fun onPasswordTyping(value: String) {
        uiState.password = value
    }

    override fun onShowPassword(show: Boolean) {
        uiState.showPassword = show
    }

    override fun onEnableButton() {
        uiState.enableButton = uiState.email.isNotEmpty() && uiState.password.isNotEmpty()
    }

    override fun onBack() {
        viewModelScope.launch(Dispatchers.Default) {
            _channel.send(SignUpUiEvent.OnBack)
        }
    }
}