package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun CurrentWeather(name: String, modifier: Modifier = Modifier) {
    Row (Modifier.padding(all = 8.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp).border(1.dp, MaterialTheme.colorScheme.primary).padding(8.dp)
        ) {
            Text(
                text = "partly cloudy",
                modifier = modifier
            )
            Text(
                text = "20°",
                modifier = modifier
            )
            Text(
                text = "Rain Amount 0%",
                modifier = modifier
            )
            Text(
                text = "SSW 13 km/h",
                modifier = modifier
            )
        }
        Image(
            painter = painterResource(R.drawable.cloud),
            contentDescription = "cloud",
            modifier = Modifier
        )
    }
}
