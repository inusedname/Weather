package com.vstd.weather.api

import com.vstd.weather.consts.WeatherProvider
import com.vstd.weather.model.CurrentWeatherData
import com.vstd.weather.model.toCurrentWeatherData
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    fun getCurrentWeatherData(
        okCallBack: () -> Unit = {},
        errorCallBack: (throwable: Throwable) -> Unit = {},
    ): CurrentWeatherData? {
        var currentWeatherData: CurrentWeatherData? = null

        weatherProvider
            ?.getCurrentWeatherResponseByLocation("Hanoi,vn")
            ?.enqueue(object : Callback<CurrentWeatherResponse> {
                override fun onResponse(
                    call: Call<CurrentWeatherResponse>,
                    response: Response<CurrentWeatherResponse>
                ) {
                    currentWeatherData = response.body()?.toCurrentWeatherData()
                    okCallBack()
                }

                override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
                    errorCallBack(t)
                }
            }
            )

        return currentWeatherData
    }

    private val weatherProvider: OpenWeatherAPI? by lazy {
        Retrofit.Builder()
            .baseUrl(WeatherProvider.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(queryParamsConfig())
            .build()
            .create(OpenWeatherAPI::class.java)
    }

    private fun queryParamsConfig(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val url = chain
                    .request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("appid", WeatherProvider.API_KEY)
                    .addQueryParameter("lang", "vi")
                    .addQueryParameter("units", "metric")
                    .build()
                chain.proceed(chain.request().newBuilder().url(url).build())
            }
            .build()
    }
}