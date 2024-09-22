package com.example.myapplaunchweather.view.weather

import com.example.myapplaunchweather.data.model.CurrentWeatherModel

data class WeatherUiState(
    val isLoading: Boolean = false,
    val data: CurrentWeatherModel? = null
)