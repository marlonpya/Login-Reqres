package com.example.loginreqres.ui.login


sealed interface LoginUiEvent {

    data class OnContinue(val email: String, val name: String) : LoginUiEvent
}