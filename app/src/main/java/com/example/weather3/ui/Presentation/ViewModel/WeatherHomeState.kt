package com.example.weather3.ui.Presentation.ViewModel

import com.example.weather3.Data.Model.WeatherForecastResult

data class WeatherHomeState(
    val isLoading: Boolean = false,
    val data: WeatherForecastResult? = null
)

sealed class WeatherHomeUiEvent{
    data class SearchIconPressed(val city: String): WeatherHomeUiEvent()
}