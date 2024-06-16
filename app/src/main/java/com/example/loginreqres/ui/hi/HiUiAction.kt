package com.example.loginreqres.ui.hi

interface HiUiAction {

    fun onContinue()
    fun onEmailTyping(value: String)
    fun onEnableButton()

    companion object {
        fun buildFake() = object : HiUiAction {
            override fun onContinue() { }
            override fun onEmailTyping(value: String) { }
            override fun onEnableButton() { }
        }
    }
}