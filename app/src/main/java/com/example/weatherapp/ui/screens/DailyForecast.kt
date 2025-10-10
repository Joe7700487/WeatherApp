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
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.WeatherAppTheme


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyForecast(mainViewModel: MainViewModel, modifier: Modifier = Modifier) {
    val weather by mainViewModel.weather.collectAsState()
    val day1 = weather?.forecast[0]
    val day2 = weather?.forecast[1]
    val day3 = weather?.forecast[2]
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
                day1?.image?.let {
                    Image(
                        painter = painterResource(it),
                        contentDescription = day1.condition,
                        modifier = Modifier.size(100.dp))
                }
                Text(
                    text = day1?.date.toString(),
                    modifier = modifier
                )
                Text(
                    text = day1?.temperatureHigh.toString() + "° - " + day1?.temperatureLow.toString() + "°",
                    modifier = modifier
                )
                Text(
                    text = day1?.condition.toString(),
                    modifier = modifier
                )
                Text(
                    text = day1?.precipitationProbability.toString() + "% " + day1?.precipitationType.toString() + " " + day1?.precipitationAmount.toString() + "mm",
                    modifier = modifier
                )
                Text(
                    text = day1?.windSpeed.toString() + "km/h - " + day1?.windDirection.toString(),
                    modifier = modifier
                )
                Text(
                    text = "humidity " + day1?.humidity.toString() + "%",
                    modifier = modifier
                )
            }
        }

        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp).border(1.dp, MaterialTheme.colorScheme.primary).padding(8.dp)

            ) {
                day2?.image?.let {
                    Image(
                        painter = painterResource(it),
                        contentDescription = day2.condition,
                        modifier = Modifier.size(100.dp))
                }
                Text(
                    text = day2?.date.toString(),
                    modifier = modifier
                )
                Text(
                    text = day2?.temperatureHigh.toString() + "° - " + day2?.temperatureLow.toString() + "°",
                    modifier = modifier
                )
                Text(
                    text = day2?.condition.toString(),
                    modifier = modifier
                )
                Text(
                    text = day2?.precipitationProbability.toString() + "% " + day2?.precipitationType.toString() + " " + day1?.precipitationAmount.toString() + "mm",
                    modifier = modifier
                )
                Text(
                    text = day2?.windSpeed.toString() + "km/h - " + day2?.windDirection.toString(),
                    modifier = modifier
                )
                Text(
                    text = "humidity " + day2?.humidity.toString() + "%",
                    modifier = modifier
                )
            }
        }

        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp).border(1.dp, MaterialTheme.colorScheme.primary).padding(8.dp)

            ) {
                day3?.image?.let {
                    Image(
                        painter = painterResource(it),
                        contentDescription = day3.condition,
                        modifier = Modifier.size(100.dp))
                }
                Text(
                    text = day3?.date.toString(),
                    modifier = modifier
                )
                Text(
                    text = day3?.temperatureHigh.toString() + "° - " + day3?.temperatureLow.toString() + "°",
                    modifier = modifier
                )
                Text(
                    text = day3?.condition.toString(),
                    modifier = modifier
                )
                Text(
                    text = day3?.precipitationProbability.toString() + "% " + day3?.precipitationType.toString() + " " + day1?.precipitationAmount.toString() + "mm",
                    modifier = modifier
                )
                Text(
                    text = day3?.windSpeed.toString() + "km/h - " + day3?.windDirection.toString(),
                    modifier = modifier
                )
                Text(
                    text = "humidity " + day3?.humidity.toString() + "%",
                    modifier = modifier
                )
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