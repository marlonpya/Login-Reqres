package com.example.loginreqres.presentation.login

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.loginreqres.utils.Updatable


@Stable
interface LoginUiState {
    val name: String
    val email: String
    val password: String
    val showPassword: Boolean
    val showProgress: Boolean
    val enableButton: Boolean
}

class MutableLoginUiState : LoginUiState, Updatable {
    override var name: String by mutableStateOf("")
    override var email: String by mutableStateOf("")
    override var password: String by mutableStateOf("")
    override var showPassword: Boolean by mutableStateOf(false)
    override var showProgress: Boolean by mutableStateOf(false)
    override var enableButton: Boolean by mutableStateOf(false)
}