package com.example.weather3.Domain

import com.example.weather3.Data.Model.WeatherForecastResult
import kotlinx.coroutines.flow.Flow


interface WeatherRepository {
    suspend fun getDailyForeCast(city : String): Flow<Result<WeatherForecastResult>>
}