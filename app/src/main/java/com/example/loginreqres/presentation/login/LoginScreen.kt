package com.example.loginreqres.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.loginreqres.R
import com.example.loginreqres.navigation.Routes
import com.example.loginreqres.ui.theme.RGreen
import com.example.loginreqres.ui.theme.fontRegular


@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel(), navController: NavHostController) {
    LaunchedEffect(Unit) {
        viewModel.channel.collect { event ->
            when (event) {
                is LoginUiEvent.OnContinue -> {
                    navController.navigate(Routes.Contacts.destination)
                }
                LoginUiEvent.OnBack -> {
                    navController.popBackStack()
                }
            }
        }
    }
    LoginScreen(viewModel = viewModel, uiState = viewModel.uiState)
}

@Composable
fun LoginScreen(viewModel: LoginUiAction, uiState: LoginUiState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pngwing),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxHeight(0.45f),
            contentScale = ContentScale.FillHeight,
            alpha = 0.3f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            Image(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Background Image",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(40.dp)
                    .clickable {
                        viewModel.onBack()
                    }
            )

            Spacer(modifier = Modifier.height(160.dp))

            Text(
                text = "Log in",
                fontSize = 36.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 16.dp)
            )

            if (uiState.showProgress) {
                Row(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            } else {

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Gray.copy(alpha = 0.5f)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.face),
                                contentDescription = "face",
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color.Gray, CircleShape)
                            )
                            Column(modifier = Modifier.padding(start = 8.dp)) {
                                Text(
                                    text = uiState.name,
                                    fontSize = fontRegular,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = uiState.email,
                                    fontSize = fontRegular,
                                    color = Color.White
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .padding(horizontal = 8.dp, vertical = 0.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            BasicTextField(
                                modifier = Modifier
                                    .weight(1f),
                                value = uiState.password,
                                onValueChange = {
                                    viewModel.onPasswordTyping(it)
                                    viewModel.onEnableButton()
                                },
                                visualTransformation = if (uiState.showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                                decorationBox = { innerTextField ->
                                    if (uiState.password.isEmpty()) {
                                        Text(
                                            text = "Password",
                                            color = Color.Gray
                                        )
                                    }
                                    innerTextField()
                                }
                            )
                            TextButton(
                                onClick = { viewModel.onShowPassword(!uiState.showPassword) },
                            ) {
                                Text(
                                    text = if (uiState.showPassword) "Hide" else "View",
                                    color = Color.Black,
                                    fontSize = fontRegular
                                )
                            }
                        }

                        Button(
                            onClick = { viewModel.onContinue() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = RGreen),
                            enabled = uiState.enableButton
                        ) {
                            Text(
                                text = "Continue",
                                color = Color.White,
                                fontSize = fontRegular
                            )
                        }

                        TextButton(onClick = { }) {
                            Text(
                                text = "Forgot your password?",
                                color = RGreen,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(vertical = 16.dp)
                            )
                        }
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(LoginUiAction.buildFake(), MutableLoginUiState())
}