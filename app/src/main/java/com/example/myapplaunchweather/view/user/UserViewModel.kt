package com.example.myapplaunchweather.view.user

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplaunchweather.core.common.utils.Validator
import com.example.myapplaunchweather.data.local.User
import com.example.myapplaunchweather.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var uiState = mutableStateOf(UserUiState())
    var validated = mutableStateOf(false)

    private val _users = MutableStateFlow(emptyList<User>())
    val users: StateFlow<List<User>> = _users

    init {
        getAllUser()
    }

    fun onEvent(event: UserUiEvent) {
        when (event) {
            is UserUiEvent.FirstNameChanged -> {
                uiState.value = uiState.value.copy(
                    firstName = event.firstName
                )
            }

            is UserUiEvent.LastNameChanged -> {
                uiState.value = uiState.value.copy(
                    lastName = event.lastName
                )
            }

            is UserUiEvent.EmailChanged -> {
                uiState.value = uiState.value.copy(
                    email = event.email
                )
            }

            is UserUiEvent.Save -> {
                save()
            }
        }
        validate()
    }

    private fun getAllUser() {
        viewModelScope.launch {
            _users.emit(repository.getAllUsers())
        }
    }

    private fun insertUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
            _users.emit(repository.getAllUsers())
        }
    }

    fun deleteUser(userId: Long) {
        viewModelScope.launch {
            repository.deleteUser(userId)
            getAllUser()
        }
    }

    private fun save() {
        insertUser(
            User(
                firstName = uiState.value.firstName,
                lastName = uiState.value.lastName,
                email = uiState.value.email
            )
        )
        resetData()
    }

    private fun validate() {
        val firstNameResult = Validator.validateFirstName(
            fName = uiState.value.firstName
        )

        val lastNameResult = Validator.validateLastName(
            lName = uiState.value.lastName
        )

        val emailResult = Validator.validateEmail(
            email = uiState.value.email
        )

        uiState.value = uiState.value.copy(
            firstNameError = firstNameResult.status,
            lastNameError = lastNameResult.status,
            emailError = emailResult.status,
        )

        validated.value = firstNameResult.status && lastNameResult.status && emailResult.status
    }

    private fun resetData() {
        uiState.value = UserUiState(
            firstName = "",
            lastName = "",
            email = ""
        )
    }
}