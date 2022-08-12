package com.vstd.weather.api

import com.vstd.weather.consts.WeatherProvider
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {

    @GET(WeatherProvider.CURRENT_WEATHER_PATH)
    fun getCurrentWeatherResponseByLocation(@Query("q") location: String): Call<CurrentWeatherResponse>

}
