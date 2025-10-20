package com.example.weatherapp.models

//noinspection SuspiciousImport
import java.time.LocalDate

data class Weather (
    val location: Location,
    val current: Current,
    val forecast: List<Forecast>
)


data class Location (
    val name: String,
    val country: String,
    val localtime: String
)
data class Current (
    val image: Int,
    val condition: String,
    val temperature: Int,
    val precipitationType: String,
    val precipitationAmount: Int,
    val windSpeed: Int,
    val windDirection: String
)

data class Forecast (
    val date: LocalDate,
    val image: Int,
    val temperatureHigh: Int,
    val temperatureLow: Int,
    val condition: String,
    val precipitationType: String,
    val precipitationAmount: Int,
    val precipitationProbability: Int,
    val windSpeed: Int,
    val windDirection: String,
    val humidity: Int
)