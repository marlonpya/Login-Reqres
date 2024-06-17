package com.example.loginreqres.presentation.hi

sealed interface HiUIEvent {

    data class OnContinue(val email: String) : HiUIEvent
}