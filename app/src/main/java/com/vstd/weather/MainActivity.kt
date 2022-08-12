package com.vstd.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vstd.weather.api.Network
import com.vstd.weather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        demo()
    }

    private fun demo() {
        val currentWeatherData = Network.getCurrentWeatherData()
        binding.tvMainTemp.text = currentWeatherData?.mainTemp.toString()
        binding.tvWeatherMainStatus.text = currentWeatherData?.weatherMainStatus
    }
}