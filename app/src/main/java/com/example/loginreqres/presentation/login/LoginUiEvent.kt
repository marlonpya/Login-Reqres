package com.example.loginreqres.presentation.login


sealed interface LoginUiEvent {

    object OnContinue : LoginUiEvent
    object OnBack : LoginUiEvent
}