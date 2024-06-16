package com.example.loginreqres.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.loginreqres.navigation.Routes
import com.example.loginreqres.navigation.Routes.Login.destinationWithParams
import com.example.loginreqres.navigation.Routes.SignUp.destinationWithParams
import com.example.loginreqres.ui.hi.HiScreen
import com.example.loginreqres.ui.login.LoginScreen
import com.example.loginreqres.ui.signup.SignUpScreen


@Composable
fun ReqresNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Hi.destination
    ) {
        composable(Routes.Hi.destination) {
            HiScreen(navController = navController)
        }
        composable(
            Routes.SignUp.destinationWithParams(),
            arguments = listOf(navArgument(Routes.SignUp.email) {
                type = NavType.StringType
            })
        ) {
            SignUpScreen(navController = navController)
        }
        composable(
            Routes.Login.destinationWithParams(),
            arguments = listOf(navArgument(Routes.Login.name) {
                type = NavType.StringType
            }, navArgument(Routes.Login.email) {
                type = NavType.StringType
            })
        ) {
            LoginScreen(navController = navController)
        }
    }
}