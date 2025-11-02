package com.example.weatherapp.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.WeatherAppTheme


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyForecast(mainViewModel: MainViewModel, modifier: Modifier = Modifier) {
    val weather by mainViewModel.weather.collectAsState()
    val day1 = weather?.forecast?.forecastDay[0]
    val day2 = weather?.forecast?.forecastDay[1]
    val day3 = weather?.forecast?.forecastDay[2]
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().padding(all = 1.dp)
    ) {
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp).border(1.dp, MaterialTheme.colorScheme.primary).padding(8.dp)

            ) {
                AsyncImage(
                    model = "https:${day1?.day?.condition?.icon}",
                    contentDescription = day1?.day?.condition?.icon.toString(),
                    Modifier.size(128.dp)
                )
                Text(
                    text = day1?.date.toString(),
                    modifier = modifier
                )
                Text(
                    text = day1?.day?.temperatureHigh.toString() + "° - " + day1?.day?.temperatureLow.toString() + "°",
                    modifier = modifier
                )
                Text(
                    text = day1?.day?.condition?.text.toString(),
                    modifier = modifier
                )
                Text(
                    text = day1?.day?.precipitationProbability.toString() + "% " + day1?.day?.precipitationAmount.toString() + "mm",
                    modifier = modifier
                )
                Text(
                    text = day1?.day?.windSpeed.toString() + "km/h - ",
                    modifier = modifier
                )
//                Text(
//                    text = "humidity " + day1?.humidity.toString() + "%",
//                    modifier = modifier
//                )
            }
        }

        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp).border(1.dp, MaterialTheme.colorScheme.primary).padding(8.dp)

            ) {
                AsyncImage(
                    model = "https:${day2?.day?.condition?.icon}",
                    contentDescription = day2?.day?.condition?.icon.toString(),
                    Modifier.size(128.dp)
                )
                Text(
                    text = day2?.date.toString(),
                    modifier = modifier
                )
                Text(
                    text = day2?.day?.temperatureHigh.toString() + "° - " + day2?.day?.temperatureLow.toString() + "°",
                    modifier = modifier
                )
                Text(
                    text = day2?.day?.condition?.text.toString(),
                    modifier = modifier
                )
                Text(
                    text = day2?.day?.precipitationProbability.toString() + "% " + day2?.day?.precipitationAmount.toString() + "mm",
                    modifier = modifier
                )
                Text(
                    text = day2?.day?.windSpeed.toString() + "km/h - ",
                    modifier = modifier
                )
//                Text(
//                    text = "humidity " + day1?.humidity.toString() + "%",
//                    modifier = modifier
//                )
            }
        }
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp).border(1.dp, MaterialTheme.colorScheme.primary).padding(8.dp)

            ) {
                AsyncImage(
                    model = "https:${day3?.day?.condition?.icon}",
                    contentDescription = day3?.day?.condition?.icon.toString(),
                    Modifier.size(128.dp)
                )
                Text(
                    text = day3?.date.toString(),
                    modifier = modifier
                )
                Text(
                    text = day3?.day?.temperatureHigh.toString() + "° - " + day3?.day?.temperatureLow.toString() + "°",
                    modifier = modifier
                )
                Text(
                    text = day3?.day?.condition?.text.toString(),
                    modifier = modifier
                )
                Text(
                    text = day3?.day?.precipitationProbability.toString() + "% " + day3?.day?.precipitationAmount.toString() + "mm",
                    modifier = modifier
                )
                Text(
                    text = day3?.day?.windSpeed.toString() + "km/h - ",
                    modifier = modifier
                )
//                Text(
//                    text = "humidity " + day1?.humidity.toString() + "%",
//                    modifier = modifier
//                )
            }
        }
    }
}

//daily forecast for 3 or more days
//
//Each forecast will include:
//- date
//- weather image
//- temperature high and low
//- condition
//- precipitation type, amount, and probability
//- wind direction and speed
//- humidity