package com.kaukabfarrukh.weathertrack

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(@Query("q") city: String, @Query("appid") apiKey: String): Response<WeatherData>

    @GET("data/2.5/forecast")
    suspend fun getForecast(@Query("q") city: String, @Query("appid") apiKey: String): Response<WeatherForecastData>
}