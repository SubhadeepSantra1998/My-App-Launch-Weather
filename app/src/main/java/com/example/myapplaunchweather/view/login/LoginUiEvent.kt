package com.example.myapplaunchweather.view.login

sealed class LoginUiEvent {
    data class EmailChanged(val email: String) : LoginUiEvent()
    data class PasswordChanged(val password: String) : LoginUiEvent()
    object Login : LoginUiEvent()
}