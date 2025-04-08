package com.kaukabfarrukh.weathertrack

data class WeatherData(
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double
)

data class Weather(
    val description: String
)

data class WeatherForecastData(
    val list: List<DailyForecast>
)

data class DailyForecast(
    val dt: Long,
    val main: ForecastMain,
    val weather: List<Weather>
)

data class ForecastMain(
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int
)