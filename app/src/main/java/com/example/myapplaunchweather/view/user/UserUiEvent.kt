package com.example.myapplaunchweather.view.user

sealed class UserUiEvent{
    data class FirstNameChanged(val firstName:String): UserUiEvent()
    data class LastNameChanged(val lastName: String) : UserUiEvent()
    data class EmailChanged(val email: String) : UserUiEvent()
    object Save : UserUiEvent()
}