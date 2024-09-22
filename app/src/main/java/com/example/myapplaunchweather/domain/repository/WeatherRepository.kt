package com.example.myapplaunchweather.domain.repository

import com.example.myapplaunchweather.core.common.Resource
import com.example.myapplaunchweather.data.model.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherData(): Flow<Resource<WeatherResponse>>
}