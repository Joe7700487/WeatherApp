package com.example.weatherapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.Condition
import com.example.weatherapp.models.Current
import com.example.weatherapp.models.Day
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.ForecastDay
import com.example.weatherapp.models.Location
import com.example.weatherapp.models.Weather
import com.example.weatherapp.services.WeatherService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class MainViewModel : ViewModel() {
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()

    // Retrofit instance
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

    fun getWeather(coordinates: String) {
        viewModelScope.launch {
            try {
                val weather = weatherService.getCurrentWeather(location = coordinates)
                _weather.value = weather
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching weather data", e)

            }
        }
    }
}