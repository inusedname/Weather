package com.vstd.weather.api

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(

    @SerializedName("coord") val coord: Coord? = Coord(),
    @SerializedName("weather") val weather: ArrayList<Weather> = arrayListOf(),
    @SerializedName("base") val base: String? = null,
    @SerializedName("main") val main: Main? = Main(),
    @SerializedName("visibility") val visibility: Int? = null,
    @SerializedName("wind") val wind: Wind? = Wind(),
    @SerializedName("rain") val rain: Rain? = Rain(),
    @SerializedName("snow") val snow: Snow? = Snow(),
    @SerializedName("clouds") val clouds: Clouds? = Clouds(),
    @SerializedName("dt") val dt: Int? = null,
    @SerializedName("sys") val sys: Sys? = Sys(),
    @SerializedName("timezone") val timezone: Int? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("cod") val cod: Int? = null
) {
    data class Coord(
        @SerializedName("lon") val lon: Double? = null,
        @SerializedName("lat") val lat: Double? = null
    )

    data class Weather(
        @SerializedName("id") val id: Int,
        @SerializedName("main") val main: String? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("icon") val icon: String? = null
    )

    data class Main(
        @SerializedName("temp") val temp: Double? = null,
        @SerializedName("feels_like") val feelsLike: Double? = null,
        @SerializedName("temp_min") val tempMin: Double? = null,
        @SerializedName("temp_max") val tempMax: Double? = null,
        @SerializedName("pressure") val pressure: Int? = null,
        @SerializedName("humidity") val humidity: Int? = null,
        @SerializedName("sea_level") val seaLevel: Int? = null,
        @SerializedName("grnd_level") val grndLevel: Int? = null
    )

    data class Wind(
        @SerializedName("speed") val speed: Double? = null,
        @SerializedName("deg") val deg: Int? = null,
        @SerializedName("gust") val gust: Double? = null
    )

    data class Rain(
        @SerializedName("1h") val rain1h: Double? = null,
        @SerializedName("3h") val rain3h: Double? = null
    )

    data class Snow(
        @SerializedName("1h") val snow1h: Double? = null,
        @SerializedName("3h") val snow3h: Double? = null
    )

    data class Clouds(
        @SerializedName("all") val all: Int? = null
    )

    data class Sys(
        @SerializedName("country") val country: String? = null,
        @SerializedName("sunrise") val sunrise: Int? = null,
        @SerializedName("sunset") val sunset: Int? = null
    )
}