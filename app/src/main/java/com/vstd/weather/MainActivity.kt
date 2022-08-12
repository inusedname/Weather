package com.vstd.weather

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vstd.weather.api.Network
import com.vstd.weather.databinding.ActivityMainBinding
import com.vstd.weather.model.CurrentWeatherData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        demo()
    }

    private fun demo() {
        Network.fetchCurrentWeather(okCallback, erCallback)
    }

    private val okCallback : (weatherData: CurrentWeatherData?) -> Unit = {
        Toast.makeText(this, "Received", Toast.LENGTH_SHORT).show()
        binding.tvMainTemp.text = it?.mainTemp.toString()
        binding.tvWeatherMainStatus.text = it?.weatherMainStatus
    }
    private val erCallback : (throwable: Throwable) -> Unit = {
        Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_LONG).show()
    }
}