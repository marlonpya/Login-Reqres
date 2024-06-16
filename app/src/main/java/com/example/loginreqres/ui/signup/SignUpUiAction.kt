package com.example.loginreqres.ui.signup

interface SignUpUiAction {

    fun onAgree()
    fun onNameTyping(value: String)
    fun onPasswordTyping(value: String)
    fun onShowPassword(show: Boolean)
    fun onEnableButton()

    companion object {
        fun buildFake() = object : SignUpUiAction {
            override fun onAgree() { }
            override fun onNameTyping(value: String) { }
            override fun onPasswordTyping(value: String) { }
            override fun onShowPassword(show: Boolean) { }
            override fun onEnableButton() { }
        }
    }
}