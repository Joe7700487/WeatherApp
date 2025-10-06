package com.example.weatherapp

import android.R.attr.label
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.screens.CurrentWeather
import com.example.weatherapp.ui.screens.DailyForecast
import com.example.weatherapp.ui.theme.WeatherAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                DisplayUI()
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DisplayUI () {
        val navController = rememberNavController()
        var selectedIndex by remember {mutableIntStateOf(0)}

        Scaffold(
            topBar = {
                // Display a top app bar with a title
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary
                    ),
                    title = {
                        Text("My Android App")
                    }
                )
            },
            bottomBar = {
                NavigationBar (
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary
                )
                {
                    NavigationBarItem(
                        icon = {
                            Icon (
                                painter = painterResource(R.drawable.clock),
                                contentDescription = "current Weather"
                            )
                        },
                        label = {
                            Text("current weather")
                        },
                        selected = selectedIndex == 0,
                        onClick = {
                            selectedIndex = 0
                            navController.navigate(route = "currentweather")
                        }
                    )
                    NavigationBarItem(
                        icon = {
                            Icon (
                                painter = painterResource(R.drawable.daily),
                                contentDescription = "dailyforecast"
                            )
                        },
                        label = {
                            Text("daily forecast")
                        },
                        selected = selectedIndex == 1,
                        onClick = {
                            selectedIndex = 1
                            navController.navigate(route = "dailyforecast")
                        }
                    )
                }
            }
        ) {
            innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "currentweather",
                modifier = Modifier.padding(innerPadding)
            )
            {
                composable(route = "currentweather") {
                    CurrentWeather("")
                }
                composable(route = "dailyforecast") {
                    DailyForecast("hello")
                }
            }
        }
    }
}
