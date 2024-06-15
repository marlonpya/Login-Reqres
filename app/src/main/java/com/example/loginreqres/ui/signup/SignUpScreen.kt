package com.example.loginreqres.ui.signup

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginreqres.R
import com.example.loginreqres.ui.theme.RGreen
import com.example.loginreqres.ui.theme.fontRegular

@Composable
fun SignUpScreen(
    onClickAgree: Runnable,
    email: String
) {

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
                text = "Sign up",
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
                    Text(
                        text = """Looks like you don't have an account. 
                            |Let's create a new account for
                        """.trimMargin(),
                        color = Color.White,
                        fontSize = fontRegular
                    )
                    Text(
                        text = email,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = Color.White,
                        fontSize = fontRegular,
                        fontWeight = FontWeight.Bold
                    )
                    var name by remember { mutableStateOf(TextFieldValue("")) }
                    BasicTextField(
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 16.dp, vertical = 16.dp),
                        decorationBox = { innerTextField ->
                            if (name.text.isEmpty()) {
                                Text(
                                    text = "Name",
                                    color = Color.Gray
                                )
                            }
                            innerTextField()
                        }
                    )

                    var password by remember { mutableStateOf("") }
                    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

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
                            value = password,
                            onValueChange = { password = it },
                            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),

                            )
                        TextButton(
                            onClick = { passwordVisibility = !passwordVisibility },
                        ) {
                            Text(
                                text = "View",
                                color = Color.Black,
                                fontSize = fontRegular
                            )
                        }
                    }

                    /*TextField(
                        value = "Password",
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Image(
                                    imageVector = Icons.Filled.KeyboardArrowLeft,
                                    contentDescription = "Background Image",
                                    colorFilter = ColorFilter.tint(Color.White),
                                    modifier = Modifier
                                        .align(Alignment.Start)
                                        .size(40.dp)
                                )
                            }
                        },
                        onValueChange = { password = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        )*/
                    Text(
                        text = "By selecting Agree and continue below,",
                        color = Color.White,
                        fontSize = fontRegular,
                        modifier = Modifier
                            .padding(top = 16.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "I agree to ",
                            color = Color.White,
                            fontSize = fontRegular
                        )
                        Text(
                            text = "Terms of Service and Privacy Policy",
                            color = RGreen,
                            fontSize = 15.sp
                        )
                    }

                    Button(
                        onClick = { onClickAgree.run() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = RGreen)
                    ) {
                        Text(
                            text = "Agree and continue",
                            color = Color.White,
                            fontSize = fontRegular
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen({}, "name@email.com")
}