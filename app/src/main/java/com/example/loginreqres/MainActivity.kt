package com.example.loginreqres

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.loginreqres.ui.hi.HiScreen
import com.example.loginreqres.ui.login.LoginScreen
import com.example.loginreqres.ui.signup.SignUpScreen
import com.example.loginreqres.ui.theme.LoginReqresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginReqresTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.Hi
                ) {
                    composable<Routes.Hi> {
                        HiScreen { navController.navigate(Routes.SignUp("name@mail.com")) }
                    }
                    composable<Routes.SignUp> {
                        val args = it.toRoute<Routes.SignUp>()
                        SignUpScreen({ navController.navigate(Routes.Login(args.email)) }, args.email)
                    }
                    composable<Routes.Login> {
                        LoginScreen()
                    }
                }
            }
        }
    }
}