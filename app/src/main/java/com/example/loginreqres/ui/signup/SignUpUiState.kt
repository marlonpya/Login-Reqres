package com.example.loginreqres.ui.signup

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.loginreqres.utils.Updatable


@Stable
interface SignUpUiState {
    val email: String
    val name: String
    val password: String
    val showPassword: Boolean
    val enableButton: Boolean
}

class MutableSignUpUiState : SignUpUiState, Updatable {
    override var email: String by mutableStateOf("")
    override var name: String by mutableStateOf("")
    override var password: String by mutableStateOf("")
    override var showPassword: Boolean by mutableStateOf(false)
    override var enableButton: Boolean by mutableStateOf(false)
}