package com.example.myapplaunchweather.core.common.utils

object Validator {

    fun validateFirstName(fName: String): ValidationResult {
        return ValidationResult(
            (fName.isNotEmpty() && fName.length >= 2)
        )

    }

    fun validateLastName(lName: String): ValidationResult {
        return ValidationResult(
            (lName.isNotEmpty() && lName.length >= 2)
        )
    }

    fun validateEmail(email: String): ValidationResult {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return ValidationResult(
            (email.isNotEmpty() && email.matches(emailRegex.toRegex()))
        )
    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            (password.isNotEmpty() && password.length >= 4)
        )
    }
}

data class ValidationResult(
    val status: Boolean = false
)