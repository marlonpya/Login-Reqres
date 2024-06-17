package com.example.loginreqres.presentation.contacts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginreqres.domain.usecase.ContactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val contactUseCase: ContactUseCase
) : ViewModel() {
    private val _uiState = MutableContactsUiState()
    val uiState = _uiState

    fun call() {
        viewModelScope.launch(Dispatchers.IO) {
            uiState.showProgress = true
            contactUseCase.invoke().onSuccess {
                uiState.showProgress = false
                uiState.contacts = it.map { Contact(it?.firstName ?: "", it?.email ?: "") }
            }.onFailure {
                uiState.showProgress = false
                Log.e("error", "${it.message} {${it.cause}}")
            }
        }
    }
}