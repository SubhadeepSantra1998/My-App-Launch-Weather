package com.example.myapplaunchweather.data.repository

import com.example.myapplaunchweather.core.common.Resource
import com.example.myapplaunchweather.data.model.WeatherResponse
import com.example.myapplaunchweather.data.remote.network.WeatherApi
import com.example.myapplaunchweather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(): Flow<Resource<WeatherResponse>> = flow {
        emit(Resource.Loading())
        try {
            val result = api.getWeather()
            emit(Resource.Success(result))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        } catch (e: Exception) {
            emit(Resource.Error("$e"))
        }
    }
}