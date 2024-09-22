package com.example.myapplaunchweather.view.user

data class UserUiState(
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var firstNameError: Boolean = false,
    var lastNameError: Boolean = false,
    var emailError: Boolean = false
)