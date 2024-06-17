package com.example.loginreqres.navigation

private const val SLASH = "/"

sealed class Routes(val destination: String) {

    object Hi : Routes("hi")
    object SignUp : Routes("signUp") {
        const val email = "email"
        fun SignUp.destinationWithParams() = this.destination.plus(SLASH).plus("{$email}")
        fun SignUp.navigateParams(email: String) = this.destination.plus(SLASH).plus(email)
    }

    object Login : Routes("login") {
        const val name = "name"
        const val email = "email"

        fun Login.destinationWithParams() =
            this.destination + SLASH + "{$name}" + SLASH + "{$email}"

        fun Login.navigateParams(name: String, email: String) =
            this.destination + SLASH + name + SLASH + email
    }

    object Contacts : Routes("contacts")
}