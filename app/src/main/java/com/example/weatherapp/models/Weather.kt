package com.example.weatherapp.models

//noinspection SuspiciousImport
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Weather (
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

data class Forecast (
    @SerializedName("forecastday") val forecastDay: List<ForecastDay>
)

data class Location (
    val name: String?,
    val country: String,
    val localtime: String
)
data class Current (
    val condition: Condition,
    @SerializedName("temp_c") val temperature: Double,
//    val precipitationType: String,
    @SerializedName("precip_mm") val precipitationAmount: Double,
    @SerializedName("wind_kph") val windSpeed: Double,
    @SerializedName("wind_dir") val windDirection: String,
)
data class ForecastDay (
    val date: String,
//    val precipitationType: String,
//    val windDirection: String,
//    val humidity: Int,
    val day: Day
)

data class Condition (
    val icon: String,
    val text: String,
)
data class Day (
    @SerializedName("totalprecip_mm") val precipitationAmount: Double,
    @SerializedName("daily_chance_of_rain") val precipitationProbability: Double,
    @SerializedName("maxwind_kph") val windSpeed: Double,
    @SerializedName("maxtemp_c") val temperatureHigh: Double,
    @SerializedName("mintemp_c") val temperatureLow: Double,
    val condition: Condition
)
