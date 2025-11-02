package com.example.weatherapp.ui.screens

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.WeatherAppTheme


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CurrentWeather(mainViewModel: MainViewModel, modifier: Modifier = Modifier) {

    val weather by mainViewModel.weather.collectAsState()
    Row (Modifier.padding(all = 8.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = "https:${weather?.current?.condition?.icon}",
                contentDescription = weather?.current?.condition?.icon.toString(),
                Modifier.size(128.dp)
            )
            Text(
                text = weather?.current?.condition?.text.toString(),
                modifier = modifier
            )
            Text(
                text = weather?.current?.temperature.toString() + "°",
                modifier = modifier
            )
//            Text(
//                text = weather?.current?.precipitationType.toString(),
//                modifier = modifier
//            )
            Text(
                text = weather?.current?.windSpeed.toString() + "km/h",
                modifier = modifier
            )
            Text(
                text = weather?.current?.windDirection.toString(),
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
