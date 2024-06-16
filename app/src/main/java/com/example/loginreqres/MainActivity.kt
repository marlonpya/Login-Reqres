package com.example.loginreqres

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.loginreqres.navigation.navhost.ReqresNavHost
import com.example.loginreqres.ui.theme.LoginReqresTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginReqresTheme {
                ReqresNavHost()
            }
        }
    }
}