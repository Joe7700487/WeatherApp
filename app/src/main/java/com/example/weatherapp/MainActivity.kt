package com.example.weatherapp

import android.Manifest
import android.R.attr.label
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.screens.CurrentWeather
import com.example.weatherapp.ui.screens.DailyForecast
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource


class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                GetLocation(mainViewModel)
                DisplayUI(mainViewModel)
            }
        }
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun GetLocation(mainViewModel: MainViewModel) {
        // Remember the permission state(asking for Fine location)
        val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

        if (permissionState.status.isGranted) {
            Log.i("TESTING", "Hurray, permission granted!")

            // Get Location
            val currentContext = LocalContext.current
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(currentContext)

            if (ContextCompat.checkSelfPermission(
                    currentContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED)
            {
                val cancellationTokenSource = CancellationTokenSource()

                Log.i("TESTING", "Requesting location...")

                fusedLocationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, cancellationTokenSource.token)
                    .addOnSuccessListener { location ->
                        if (location != null) {
                            val lat = location.latitude.toString()
                            val lng = location.longitude.toString()

                            Log.i("TESTING", "Success: $lat $lng")

                            val coordinates = "$lat,$lng"

                            // call a function, like in View Model, to do something with location...
                            mainViewModel.getWeather(coordinates)
                        }
                        else {
                            Log.i("TESTING", "Problem encountered: Location returned null")
                        }
                    }
            }
        }
        else {
            // Run a side-effect (coroutine) to get permission. The permission popup.
            LaunchedEffect(permissionState){
                permissionState.launchPermissionRequest()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DisplayUI (mainViewModel: MainViewModel) {
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
                        val weather by mainViewModel.weather.collectAsStateWithLifecycle()
                        val location = weather?.location?.let { loc -> "${loc.name}, ${loc.country}"} ?: "Loading..."
                        Text(location)
                    },
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
                                painter = painterResource(R.drawable.current),
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
                                painter = painterResource(R.drawable.forecast),
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
                    CurrentWeather(mainViewModel)
                }
                composable(route = "dailyforecast") {
                    DailyForecast(mainViewModel)
                }
            }
        }
    }

}
