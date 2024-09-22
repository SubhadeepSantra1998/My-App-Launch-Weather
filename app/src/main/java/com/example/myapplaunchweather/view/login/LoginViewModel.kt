package com.example.myapplaunchweather.view.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplaunchweather.core.common.utils.Validator
import com.example.myapplaunchweather.domain.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val repository: DataStoreRepository
): ViewModel() {

    var loginUIState = mutableStateOf(LoginUiState())
    var validated = mutableStateOf(false)

    fun saveLoginState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveLoginState(completed = completed)
        }
    }

    fun onEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }

            is LoginUiEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }

            is LoginUiEvent.Login -> {
                saveLoginState(true)
            }
        }
        validate()
    }

    private fun validate() {
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        validated.value = emailResult.status && passwordResult.status
    }
}