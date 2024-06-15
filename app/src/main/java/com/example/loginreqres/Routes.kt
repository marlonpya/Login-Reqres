package com.example.loginreqres

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object Hi: Routes()
    @Serializable
    data class SignUp(val email: String): Routes()
    @Serializable
    data class Login(val name: String): Routes()
}