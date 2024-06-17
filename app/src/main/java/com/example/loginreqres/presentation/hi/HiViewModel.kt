package com.example.loginreqres.presentation.hi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginreqres.utils.FormatValidate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HiViewModel @Inject constructor(): ViewModel(), HiUiAction {
    private val _uiState = MutableHiUiState()
    val uiState = _uiState

    private val _channel = Channel<HiUIEvent>()
    val channel: Flow<HiUIEvent> = _channel.receiveAsFlow()

    override fun onContinue() {
        viewModelScope.launch(Dispatchers.Default) {
            _channel.send(HiUIEvent.OnContinue(uiState.email))
        }
    }

    override fun onEmailTyping(value: String) {
        uiState.email = value
    }

    override fun onEnableButton() {
        uiState.enableButton = uiState.email.isNotEmpty() && FormatValidate.isValidString(uiState.email)
    }
}