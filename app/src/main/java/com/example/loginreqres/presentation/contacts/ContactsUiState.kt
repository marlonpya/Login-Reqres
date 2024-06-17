package com.example.loginreqres.presentation.contacts

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.loginreqres.utils.Updatable


@Stable
interface ContactsUiState {
    val showProgress: Boolean
    val contacts: List<Contact>
}

class MutableContactsUiState : ContactsUiState, Updatable {
    override var showProgress: Boolean by mutableStateOf(false)
    override var contacts: List<Contact> by mutableStateOf(emptyList())
}