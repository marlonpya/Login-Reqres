package com.example.loginreqres.ui.hi

sealed interface HiUIEvent {

    data class OnContinue(val email: String) : HiUIEvent
}