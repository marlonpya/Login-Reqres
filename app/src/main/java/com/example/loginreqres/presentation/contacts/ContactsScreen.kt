package com.example.loginreqres.presentation.contacts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.loginreqres.ui.theme.fontRegular


@Composable
fun ContactsScreen(viewModel: ContactsViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.call()
    }

    Box {
        if (viewModel.uiState.showProgress) {
            Row(modifier = Modifier.fillMaxWidth()) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(modifier = Modifier.padding(top = 30.dp)) {
                items(viewModel.uiState.contacts) { contact ->
                    ContactCardScreen(contact.name, contact.email)
                }
            }
        }
    }
}

@Composable
fun ContactCardScreen(name: String, email: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray.copy(alpha = 0.5f)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = name,
                    fontSize = fontRegular,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = email,
                    fontSize = fontRegular,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewContactCardScreen() {
    ContactCardScreen("Doe", "Doe@gmail.com")
}