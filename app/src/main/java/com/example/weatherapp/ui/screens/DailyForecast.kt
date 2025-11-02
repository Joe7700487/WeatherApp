package com.example.weatherapp.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R
import com.example.weatherapp.models.ForecastDay
import com.example.weatherapp.ui.theme.WeatherAppTheme
import kotlin.math.absoluteValue
import androidx.compose.ui.util.lerp


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyForecast(mainViewModel: MainViewModel, modifier: Modifier = Modifier) {
    val weather by mainViewModel.weather.collectAsState()
//    val day1 = weather?.forecast?.forecastDay[0]
//    val day2 = weather?.forecast?.forecastDay[1]
//    val day3 = weather?.forecast?.forecastDay[2]
    val days = weather?.forecast?.forecastDay ?: emptyList()

    val state = rememberLazyListState()

    BoxWithConstraints (
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyRow (
            state = state,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(horizontal = this.maxWidth / 2 - 80.dp)
        ) {
            itemsIndexed(days) {i, day ->
                val scale by remember {
                    derivedStateOf {
                        val currentState = state.layoutInfo.visibleItemsInfo.firstOrNull { it.index == i } ?: return@derivedStateOf 0.8f

                        val itemCenter = currentState.offset + currentState.size / 2
                        val distance = (itemCenter - (state.layoutInfo.viewportEndOffset / 2)).absoluteValue
                        val maxDistance = state.layoutInfo.viewportEndOffset / 2

                        lerp(
                            start = 1f,
                            stop = 0.8f,
                            fraction = (distance.toFloat() / maxDistance).coerceIn(0f, 1f)
                        )
                    }
                }
                ForecastDay(
                    day = day,
                    modifier = Modifier.graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }
                )
            }
        }
    }
}

@Composable
fun ForecastDay(day: ForecastDay?, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(16.dp)
            .border(1.dp, MaterialTheme.colorScheme.primary)
            .padding(8.dp)

    ) {
        AsyncImage(
            model = "https:${day?.day?.condition?.icon}",
            contentDescription = day?.day?.condition?.icon.toString(),
            Modifier.size(128.dp)
        )
        Text(
            text = day?.date.toString(),
            fontSize = 25.sp
        )
        Text(
            text = "High: " + day?.day?.temperatureHigh.toString(),
            fontSize = 25.sp
        )
        Text(
            text ="Low: " + day?.day?.temperatureLow.toString() + "°",
            fontSize = 25.sp
        )
        Text(
            text = day?.day?.condition?.text.toString(),
            fontSize = 25.sp
        )
        Text(
            text = day?.day?.precipitationProbability.toString() + "% rain, " + day?.day?.precipitationAmount.toString() + "mm",
            fontSize = 25.sp
        )
        Text(
            text = "Wind speed: " + day?.day?.windSpeed.toString() + "km/h",
            fontSize = 25.sp
        )
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