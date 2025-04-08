package com.kaukabfarrukh.weathertrack

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    val weatherData = repository.weatherData
    val errorMessages = repository.errorMessages

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            repository.fetchWeather(city, apiKey)
        }
    }
}

class WeatherRepository {
    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData: LiveData<WeatherData> = _weatherData

    private val _errorMessages = MutableLiveData<String>()
    val errorMessages: LiveData<String> = _errorMessages

    private val weatherService: WeatherService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }

    suspend fun fetchWeather(city: String, apiKey: String) {
        try {
            val response = weatherService.getCurrentWeather(city, apiKey)
            if (response.isSuccessful) {
                response.body()?.let {
                    _weatherData.postValue(it)
                    Log.d("WeatherRepository", "Weather data fetched successfully.")
                } ?: _errorMessages.postValue("No weather data found.")
            } else {
                _errorMessages.postValue("API call failed: ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            _errorMessages.postValue("Failed to fetch weather data: ${e.localizedMessage}")
        }
    }
}
