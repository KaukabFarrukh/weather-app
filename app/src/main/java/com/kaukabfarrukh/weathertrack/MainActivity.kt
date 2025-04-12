package com.kaukabfarrukh.weathertrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.runtime.state.collectAsState
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.kaukabfarrukh.weathertrack.WeatherViewModel
import com.kaukabfarrukh.weathertrack.ui.theme.WeatherTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTrackTheme {
                WeatherApp()
            }
        }
    }

    @Composable fun WeatherApp() {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Weather App") },
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                )
            }
        ) { innerPadding ->
            NavHost(navController = navController, startDestination = "currentWeather", modifier = Modifier.padding(innerPadding)) {
                composable("currentWeather") {
                    CurrentWeatherScreen(navController)
                }
                composable("forecast") {
                    ForecastScreen(navController)
                }
            }
        }
    }

    @Composable fun CurrentWeatherScreen(navController: NavController) {
        val viewModel: WeatherViewModel = viewModel()
        val weatherData by viewModel.weatherData.observeAsState()
        val errorMessage by viewModel.errorMessages.observeAsState("")

        Column(modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            weatherData?.let { data ->
                Text("Current weather: ${data.weather.first().description} ${data.main.temp}°C")
                Button(onClick = { navController.navigate("forecast") }) {
                    Text("View 5-Day Forecast")
                }
            } ?: Text("Loading weather...")
            if (errorMessage.isNotEmpty()) {
                Text(errorMessage, color = Color.Red)
            }
        }

        LaunchedEffect(true) {
            viewModel.fetchWeather("Eslöv", "your_api_key_here") // Replace "your_api_key_here" with your actual API key
        }
    }

    @Composable fun ForecastScreen(navController: NavController) {
        val viewModel: WeatherViewModel = viewModel()
        val forecastData by viewModel.weatherData.observeAsState()
        val errorMessage by viewModel.errorMessages.observeAsState("")

        Column(modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
/*            forecastData?.let {
                it.list.forEach { forecast ->
                    Text("Forecast for ${forecast.dt}: ${forecast.weather.first().description}")
                    Text("with a high of ${forecast.main.tempMax}°C and low of ${forecast.main.tempMin}°C")
                }
            } ?: Text("Loading forecast...")
            if (errorMessage.isNotEmpty()) {
                Text(errorMessage, color = Color.Red)
            }*/
            Spacer(Modifier.height(16.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Back to Current Weather")
            }
        }

        LaunchedEffect(true) {
            // Replace "your_api_key_here" with your actual API key
            // viewModel.fetchForecast("Eslöv", "your_api_key_here")

            viewModel.fetchForecast("Eslöv", "your_api_key_here")
        }
    }
}
/*
@Preview(showBackground = true)
@Composable fun AppPreview() {
    WeatherApp()
}
*/