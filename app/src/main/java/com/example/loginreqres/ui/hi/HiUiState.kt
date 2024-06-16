package com.example.loginreqres.ui.hi

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.loginreqres.utils.Updatable


@Stable
interface HiUiState {
    val email: String
    val enableButton: Boolean
}

class MutableHiUiState : HiUiState, Updatable {
    override var email: String by mutableStateOf("")
    override var enableButton: Boolean by mutableStateOf(false)
}