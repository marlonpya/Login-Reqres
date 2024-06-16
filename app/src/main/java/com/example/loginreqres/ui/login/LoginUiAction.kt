package com.example.loginreqres.ui.login

interface LoginUiAction {

    fun onContinue()
    fun onPasswordTyping(value: String)
    fun onShowPassword(show: Boolean)
    fun onEnableButton()

    companion object {
        fun buildFake() = object : LoginUiAction {
            override fun onContinue() {}
            override fun onPasswordTyping(value: String) {}
            override fun onShowPassword(show: Boolean) { }
            override fun onEnableButton() {}
        }
    }
}