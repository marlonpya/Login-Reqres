package com.example.loginreqres.presentation.signup

sealed interface SignUpUiEvent {

    data class OnAgree(val name: String, val email: String) : SignUpUiEvent
    object OnBack: SignUpUiEvent
}