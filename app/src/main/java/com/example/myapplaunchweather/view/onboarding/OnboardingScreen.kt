package com.example.myapplaunchweather.view.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplaunchweather.R
import com.example.myapplaunchweather.core.common.components.NormalBodyTextComponent
import com.example.myapplaunchweather.core.common.components.NormalHeadingTextComponent
import com.example.myapplaunchweather.core.common.components.TextButtonComponent
import com.example.myapplaunchweather.core.navigation.Screen

@Composable
fun OnboardingScreen(
    navController: NavController,
    onboardingViewModel: OnboardingViewModel = hiltViewModel()
) {
    OnboardingScreenContent(
        navController = navController,
        viewModel = onboardingViewModel
    )
}

@Composable
private fun OnboardingScreenContent(
    navController: NavController,
    viewModel: OnboardingViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NormalHeadingTextComponent(value = stringResource(id = R.string.welcome))

        Spacer(modifier = Modifier.height(16.dp))
        TextButtonComponent(
            text = stringResource(id = R.string.login),
            onClick = { navController.navigate(viewModel.startDestination.value) }
        )
    }
}