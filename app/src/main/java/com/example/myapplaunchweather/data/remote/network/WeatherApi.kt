package com.example.myapplaunchweather.data.remote.network

import com.example.myapplaunchweather.BuildConfig
import com.example.myapplaunchweather.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        const val BASE_URL = BuildConfig.BASE_URL
        const val ONECALL = "${BASE_URL}data/2.5/onecall"
        const val API_KEY = BuildConfig.API_KEY
        const val LAT = "12.9082847623315"
        const val LONG = "77.65197822993314"
        const val UNITS = "imperial"
    }

    @GET(ONECALL)
    suspend fun getWeather(
        @Query("lat") lat: String = LAT,
        @Query("lon") lon: String = LONG,
        @Query("units") units: String = UNITS,
        @Query("appid") appid: String = API_KEY
    ): WeatherResponse
}