package com.example.weatherapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.Current
import com.example.weatherapp.models.Forecast
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

    init {


        val today = Weather(
            Location(
                name = "Halifax",
                country = "Canada",
                localtime = "123"
            ),
            Current(
                image = R.drawable.cloud,
                condition = "Cloudy",
                temperature = 5,
                precipitationType = "rain",
                precipitationAmount = 5,
                windSpeed = 5,
                windDirection = "W",
            ),
            forecast = listOf(
                Forecast (
                    date = LocalDate.of(2025, 1, 15),
                    temperatureLow = 5,
                    temperatureHigh = 40,
                    image = R.drawable.cloud,
                    condition = "Cloudy",
                    precipitationType = "rain",
                    precipitationAmount = 4,
                    precipitationProbability = 85,
                    windSpeed = 15,
                    windDirection = "NW",
                    humidity = 5
                ),
                Forecast (
                    date = LocalDate.of(2025, 1, 16),
                    temperatureLow = 25,
                    temperatureHigh = 45,
                    image = R.drawable.sun,
                    condition = "Sunny",
                    precipitationType = "rain",
                    precipitationAmount = 0,
                    precipitationProbability = 5,
                    windSpeed = 5,
                    windDirection = "E",
                    humidity = 20
                ),
                Forecast (
                    date = LocalDate.of(2025, 1, 17),
                    temperatureLow = 5,
                    temperatureHigh = 6,
                    image = R.drawable.rain,
                    condition = "raining",
                    precipitationType = "rain",
                    precipitationAmount = 20,
                    precipitationProbability = 100,
                    windSpeed = 10,
                    windDirection = "N",
                    humidity = 100
                )
            )
        )
        _weather.value = today
    }
}