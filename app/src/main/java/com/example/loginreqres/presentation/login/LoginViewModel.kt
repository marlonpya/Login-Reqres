package com.example.loginreqres.presentation.login

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginreqres.domain.usecase.LoginUseCase
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
    private val loginUseCase: LoginUseCase,
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
        viewModelScope.launch(Dispatchers.IO) {
            uiState.showProgress = true
            loginUseCase.invoke().onSuccess {
                _channel.send(LoginUiEvent.OnContinue)
                uiState.showProgress = false
            }.onFailure {
                uiState.showProgress = false
                Log.e("error", "${it.message} {${it.cause}}")
            }
        }
    }

    override fun onPasswordTyping(value: String) {
        uiState.password = value
    }

    override fun onShowPassword(show: Boolean) {
        uiState.showPassword = show
    }

    override fun onShowProgress(show: Boolean) {
        uiState.showProgress = show
    }

    override fun onEnableButton() {
        uiState.enableButton = uiState.password.isNotEmpty()
    }

    override fun onBack() {
        viewModelScope.launch(Dispatchers.IO) {
            _channel.send(LoginUiEvent.OnBack)
        }
    }
}