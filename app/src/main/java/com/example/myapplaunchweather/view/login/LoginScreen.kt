package com.example.myapplaunchweather.view.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplaunchweather.R
import com.example.myapplaunchweather.core.common.components.NormalHeadingTextComponent
import com.example.myapplaunchweather.core.common.components.NormalTitleTextComponent
import com.example.myapplaunchweather.core.common.components.OutlinedTextFieldComponent
import com.example.myapplaunchweather.core.common.components.TextButtonComponent
import com.example.myapplaunchweather.core.navigation.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    LoginScreenContent(
        navController = navController,
        viewModel = loginViewModel
    )
}

@Composable
private fun LoginScreenContent(
    navController: NavController,
    viewModel: LoginViewModel
) {
    val uiState = viewModel.loginUIState.value
    val isValidated = viewModel.validated.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NormalHeadingTextComponent(value = stringResource(id = R.string.login))

        Spacer(modifier = Modifier.height(8.dp))

        NormalTitleTextComponent(value = stringResource(id = R.string.please_login_to_continue))

        Spacer(modifier = Modifier.height(28.dp))

        OutlinedTextFieldComponent(
            label = stringResource(id = R.string.email),
            value = uiState.email,
            modifier = Modifier.fillMaxWidth(),
            onTextChanged = {
                viewModel.onEvent(LoginUiEvent.EmailChanged(it))
            },
            errorStatus = uiState.emailError
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextFieldComponent(
            label = stringResource(id = R.string.password),
            value = uiState.password,
            modifier = Modifier.fillMaxWidth(),
            onTextChanged = {
                viewModel.onEvent(LoginUiEvent.PasswordChanged(it))
            },
            errorStatus = uiState.passwordError
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.login),
            onClick = {
                viewModel.onEvent(LoginUiEvent.Login)
                navController.popBackStack()
                navController.navigate(Screen.UserList.route)
            },
            isEnabled = isValidated
        )
    }
}