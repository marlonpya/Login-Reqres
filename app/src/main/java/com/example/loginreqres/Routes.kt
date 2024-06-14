package com.example.loginreqres

sealed class Routes(val route: String) {

    object Hi: Routes("Hi")
    object SignUp: Routes("Sign Up")
    object Login: Routes("Login")
}