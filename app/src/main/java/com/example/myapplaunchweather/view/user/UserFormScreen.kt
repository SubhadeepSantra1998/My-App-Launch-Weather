package com.example.myapplaunchweather.view.user

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplaunchweather.R
import com.example.myapplaunchweather.core.common.components.NormalHeadingTextComponent
import com.example.myapplaunchweather.core.common.components.OutlinedTextFieldComponent
import com.example.myapplaunchweather.core.common.components.TextButtonComponent
import com.example.myapplaunchweather.core.navigation.Screen

@Composable
fun UserFormScreen(
    navController: NavController,
    viewModel: UserViewModel = hiltViewModel()
) {
    UserFormScreenContent(
        navController = navController,
        viewModel = viewModel
    )
}

@Composable
private fun UserFormScreenContent(
    navController: NavController,
    viewModel: UserViewModel,
) {
    val uiState = viewModel.uiState.value
    val isValidated = viewModel.validated.value
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NormalHeadingTextComponent(value = stringResource(id = R.string.fill_up_details))

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextFieldComponent(
            label = stringResource(id = R.string.first_name),
            value = uiState.firstName,
            modifier = Modifier.fillMaxWidth(),
            onTextChanged = {
                viewModel.onEvent(UserUiEvent.FirstNameChanged(it))
            },
            errorStatus = uiState.firstNameError
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextFieldComponent(
            label = stringResource(id = R.string.last_name),
            value = uiState.lastName,
            modifier = Modifier.fillMaxWidth(),
            onTextChanged = {
                viewModel.onEvent(UserUiEvent.LastNameChanged(it))
            },
            errorStatus = uiState.lastNameError
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextFieldComponent(
            label = stringResource(id = R.string.email),
            value = uiState.email,
            modifier = Modifier.fillMaxWidth(),
            onTextChanged = {
                viewModel.onEvent(UserUiEvent.EmailChanged(it))
            },
            errorStatus = uiState.emailError
        )

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextButtonComponent(
                text = stringResource(id = R.string.cancel),
                onClick = {
                    navController.navigate(Screen.UserList.route)
                }
            )

            TextButtonComponent(
                text = stringResource(id = R.string.save),
                onClick = {
                    viewModel.onEvent(UserUiEvent.Save)
                    Toast.makeText(context, "Data Saved!", Toast.LENGTH_SHORT).show()
                },
                isEnabled = isValidated
            )
        }
    }
}