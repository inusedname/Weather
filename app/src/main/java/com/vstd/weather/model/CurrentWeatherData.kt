package com.vstd.weather.model

import com.vstd.weather.api.CurrentWeatherResponse

data class CurrentWeatherData(
    val weatherMainStatus: String? = null,
    val weatherDescriptionStatus: String? = null,
    val weatherIconPath: String? = null,
    val mainTemp: Int? = null,
    val mainFeelsLike: Int? = null,
    val mainPressure: Int? = null,
    val mainHumidity: Int? = null,
    val mainTempMin: Int? = null,
    val mainTempMax: Int? = null,
    val visibility: Int? = null,
    val windSpeed: Int? = null,
    val windDeg: Int? = null,
    val cloudiness: Int? = null,
    val rain1h: Int? = null,
    val snow1h: Int? = null,
    val timestamp: Int? = null,
    val countryName: String? = null,
    val sunrise: Int? = null,
    val sunset: Int? = null,
    val timezone: Int? = null,
    val id: Int? = null,
    val cityName: String? = null,
)

fun CurrentWeatherResponse.toCurrentWeatherData() = CurrentWeatherData(
    weatherMainStatus = weather[0].main,
    weatherDescriptionStatus = weather[0].description,
    weatherIconPath = weather[0].icon,
    mainTemp = main?.temp?.toInt(),
    mainFeelsLike = main?.feelsLike?.toInt(),
    mainPressure = main?.pressure,
    mainHumidity = main?.humidity,
    mainTempMin = main?.tempMin?.toInt(),
    mainTempMax = main?.tempMax?.toInt(),
    visibility = visibility,
    windSpeed = wind?.speed?.toInt(),
    windDeg = wind?.deg,
    cloudiness = clouds?.all,
    rain1h = rain?.rain1h?.toInt(),
    snow1h = snow?.snow1h?.toInt(),
    timestamp = dt,
    countryName = sys?.country,
    sunrise = sys?.sunrise,
    sunset = sys?.sunset,
    timezone = timezone,
    id = id,
    cityName = name,
)