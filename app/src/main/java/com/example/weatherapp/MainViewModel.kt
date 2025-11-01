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

    init {
        viewModelScope.launch {
            try {
                val weather = weatherService.getCurrentWeather()
                _weather.value = weather
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching weather data", e)

            }
        }
//        val today = Weather(
//            Location(
//                name = "Halifax",
//                country = "Canada",
//                localtime = "123"
//            ),
//            Current(
//                Condition(
//                    icon = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
//                    text = "cloudy",
//                ),
//                temperature = 5.0,
////                precipitationType = "rain",
//                precipitationAmount = 5.0,
//                windSpeed = 5.0,
//                windDirection = "W",
//            ),
//            Forecast(
//                forecastDay = listOf(
//                    ForecastDay(
//                        date = "2025, 1, 15",
//                        Day(
//                            precipitationAmount = 5.1,
//                            precipitationProbability = 6.0,
//                            windSpeed = 7.0,
//                            temperatureHigh = 8.0,
//                            temperatureLow = 9.0,
//                            Condition (
//                                icon = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
//                                text = "cloudy",
//                            )
//                        )
////                    precipitationType = "rain",
////                    windDirection = "NW",
////                    humidity = 5
//                    ),
//                    ForecastDay(
//                        date = "2025, 1, 15",
//                        Day(
//                            precipitationAmount = 5.1,
//                            precipitationProbability = 6.0,
//                            windSpeed = 7.0,
//                            temperatureHigh = 8.0,
//                            temperatureLow = 9.0,
//                            Condition (
//                                icon = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
//                                text = "cloudy",
//                            )
//                        )
////                    precipitationType = "rain",
////                    windDirection = "NW",
////                    humidity = 5
//                    ),
//                    ForecastDay(
//                        date = "2025, 1, 15",
//                        Day(
//                            precipitationAmount = 5.1,
//                            precipitationProbability = 6.0,
//                            windSpeed = 7.0,
//                            temperatureHigh = 8.0,
//                            temperatureLow = 9.0,
//                            Condition (
//                                icon = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
//                                text = "cloudy",
//                            )
//                        )
////                    precipitationType = "rain",
////                    windDirection = "NW",
////                    humidity = 5
//                    ),
//                )
//            )
//        )
        _weather.value = weather.value
    }
}