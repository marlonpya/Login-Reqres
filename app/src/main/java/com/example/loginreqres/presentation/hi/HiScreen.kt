package com.example.loginreqres.presentation.hi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.loginreqres.R
import com.example.loginreqres.navigation.Routes
import com.example.loginreqres.navigation.Routes.SignUp.navigateParams
import com.example.loginreqres.ui.theme.RGreen
import com.example.loginreqres.ui.theme.fontRegular

@Composable
fun HiScreen(viewModel: HiViewModel = hiltViewModel(), navController: NavHostController) {
    LaunchedEffect(Unit) {
        viewModel.channel.collect { event ->
            when (event) {
                is HiUIEvent.OnContinue -> {
                    navController.navigate(Routes.SignUp.navigateParams(event.email))
                }
            }
        }
    }

    HiScreen(viewModel, viewModel.uiState)
}

@Composable
fun HiScreen(viewModel: HiUiAction, uiState: HiUiState) {
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
            )

            Spacer(modifier = Modifier.height(160.dp))

            Text(
                text = "Hi!",
                fontSize = 36.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 16.dp)
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Gray.copy(alpha = 0.5f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    BasicTextField(
                        value = uiState.email,
                        onValueChange = {
                            viewModel.onEmailTyping(it)
                            viewModel.onEnableButton()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 16.dp, vertical = 16.dp),
                        decorationBox = { innerTextField ->
                            if (uiState.email.isEmpty()) {
                                Text(
                                    text = "Email",
                                    color = Color.Gray
                                )
                            }
                            innerTextField()
                        }
                    )

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
                        Text(text = "Continue", color = Color.White, fontSize = fontRegular)
                    }

                    Text(
                        text = "or",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = fontRegular,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    )

                    SocialLoginButton(
                        text = "Continue with Facebook",
                        color = Color(0xFF1877F2),
                        onClick = { /* Handle Facebook Login */ }
                    )
                    SocialLoginButton(
                        text = "Continue with Google",
                        color = Color(0xFFDB4437),
                        onClick = { /* Handle Google Login */ }
                    )
                    SocialLoginButton(
                        text = "Continue with Apple",
                        color = Color.Black,
                        onClick = { /* Handle Apple Login */ }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Don't have an account?",
                            color = Color.White,
                            fontSize = fontRegular
                        )
                        TextButton(onClick = { /* Handle Sign Up */ }) {
                            Text(text = "Sign up", color = RGreen, fontSize = fontRegular)
                        }
                    }

                    TextButton(onClick = { /* Handle Forgot Password */ }) {
                        Text(text = "Forgot your password?", color = RGreen, fontSize = fontRegular)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHiScreen() {
    HiScreen(viewModel = HiUiAction.buildFake(), uiState = MutableHiUiState())
}

@Composable
fun SocialLoginButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .height(50.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(text = text, color = Color.White, fontSize = 16.sp)
    }
}