package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.WeatherAppTheme


@Composable
fun DailyForecast(name: String, modifier: Modifier = Modifier) {
    Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize().padding(all = 1.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp).border(1.dp, MaterialTheme.colorScheme.primary).padding(8.dp)

        ) {
            Image(
                painter = painterResource(R.drawable.cloud),
                contentDescription = "cloud",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "Sept 9, 2025",
                modifier = modifier
            )
            Text(
                text = "19° 10°",
                modifier = modifier
            )
            Text(
                text = "cloudy",
                modifier = modifier
            )
            Text(
                text = "Rain 24%",
                modifier = modifier
            )
            Text(
                text = "SE9 km/h",
                modifier = modifier
            )
            Text(
                text = "humidity 69%",
                modifier = modifier
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp).border(1.dp, MaterialTheme.colorScheme.primary).padding(8.dp)

        ) {
            Image(
                painter = painterResource(R.drawable.cloud),
                contentDescription = "cloud",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "Sept 10, 2025",
                modifier = modifier
            )
            Text(
                text = "19° 10°",
                modifier = modifier
            )
            Text(
                text = "cloudy",
                modifier = modifier
            )
            Text(
                text = "Rain 24%",
                modifier = modifier
            )
            Text(
                text = "SE9 km/h",
                modifier = modifier
            )
            Text(
                text = "humidity 69%",
                modifier = modifier
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp).border(1.dp, MaterialTheme.colorScheme.primary).padding(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.cloud),
                contentDescription = "cloud",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "Sept 11, 2025",
                modifier = modifier
            )
            Text(
                text = "19° 10°",
                modifier = modifier
            )
            Text(
                text = "cloudy",
                modifier = modifier
            )
            Text(
                text = "Rain 24%",
                modifier = modifier
            )
            Text(
                text = "SE9 km/h",
                modifier = modifier
            )
            Text(
                text = "humidity 69%",
                modifier = modifier
            )

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