package com.example.myapplaunchweather.view.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.myapplaunchweather.R
import com.example.myapplaunchweather.core.common.components.BackButtonComponent
import com.example.myapplaunchweather.core.common.components.NormalBodyTextComponent
import com.example.myapplaunchweather.core.common.components.NormalHeadingTextComponent
import com.example.myapplaunchweather.core.common.components.NormalTitleTextComponent
import com.example.myapplaunchweather.core.common.components.TextButtonComponent
import com.example.myapplaunchweather.core.navigation.Screen
import com.example.myapplaunchweather.view.weather.components.WeatherComponent

@Composable
fun WeatherScreen(
    navController: NavController,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    WeatherScreenContent(
        navController = navController,
        viewModel = viewModel,
    )
}

@Composable
private fun WeatherScreenContent(
    navController: NavController,
    viewModel: WeatherViewModel,
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BackButtonComponent(
                onBackClick = {
                    navController.popBackStack()
                }
            )

            TextButtonComponent(
                text = stringResource(id = R.string.logout),
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.Onboarding.route)
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        NormalHeadingTextComponent(
            value = stringResource(R.string.temperature_in_deg, uiState.value.data?.temp.toString())
        )

        Spacer(modifier = Modifier.height(8.dp))

        NormalTitleTextComponent(value = uiState.value.data?.weather?.get(0)?.description.toString())

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        ) {
            WeatherComponent(
                modifier = Modifier.weight(1f),
                weatherLabel = stringResource(R.string.humidity),
                weatherValue = uiState.value.data?.humidity.toString(),
                weatherUnit = stringResource(R.string.humidity_unit),
                iconId = R.drawable.ic_humidity,
            )

            WeatherComponent(
                modifier = Modifier.weight(1f),
                weatherLabel = stringResource(R.string.wind_speed),
                weatherValue = uiState.value.data?.wind_speed.toString(),
                weatherUnit = stringResource(R.string.wind_speed_unit),
                iconId = R.drawable.ic_wind
            )
        }
    }
}