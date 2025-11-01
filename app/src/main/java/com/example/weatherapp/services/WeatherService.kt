package com.example.weatherapp.services

import com.example.weatherapp.models.Current
import com.example.weatherapp.models.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    @GET("v1/forecast.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String = "b7e3965f31a3461bbd3182823251610 ",
        @Query("q") location: String = "B3H",
        @Query("days") days: Int = 3,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): Weather

}