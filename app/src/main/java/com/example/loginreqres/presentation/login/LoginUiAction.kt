package com.example.loginreqres.presentation.login

interface LoginUiAction {

    fun onContinue()
    fun onPasswordTyping(value: String)
    fun onShowPassword(show: Boolean)
    fun onShowProgress(show: Boolean)
    fun onEnableButton()
    fun onBack()

    companion object {
        fun buildFake() = object : LoginUiAction {
            override fun onContinue() {}
            override fun onPasswordTyping(value: String) {}
            override fun onShowPassword(show: Boolean) { }
            override fun onShowProgress(show: Boolean) { }
            override fun onEnableButton() {}
            override fun onBack() {}
        }
    }
}