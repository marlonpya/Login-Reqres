package com.example.loginreqres.ui.signup

sealed interface SignUpUiEvent {

    data class OnAgree(val name: String, val email: String) : SignUpUiEvent
}