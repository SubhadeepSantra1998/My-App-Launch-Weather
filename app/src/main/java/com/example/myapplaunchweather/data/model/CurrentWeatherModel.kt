package com.example.myapplaunchweather.data.model

data class CurrentWeatherModel(
    var clouds: Int? = null,
    var dew_point: Double? = null,
    var dt: Int? = null,
    var feels_like: Double? = null,
    var humidity: Int? = null,
    var pressure: Int? = null,
    var sunrise: Int? = null,
    var sunset: Int? = null,
    var temp: Double? = null,
    var uvi: Double? = null,
    var visibility: Int? = null,
    var weather: List<Weather>? = null,
    var wind_deg: Int? = null,
    var wind_speed: Double? = null
)