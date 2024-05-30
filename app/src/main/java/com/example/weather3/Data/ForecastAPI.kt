package com.example.weather3.Data

import com.example.weather3.Data.Model.WeatherForecastResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastAPI {
    @GET("daily") //daily API version
    suspend fun getDailyForeCast(
        @Query("city") city : String,
        @Query("key") key: String = API_KEY
    ): WeatherForecastResult

    companion object{
        const val BASE_URL = "https://api.weatherbit.io/v2.0/forecast/"
        const val API_KEY = "eceff76f289a4da6a6eae5730c09d9b7"
    }

}

//https://api.weatherbit.io/v2.0/forecast/daily?city=Raleigh,NC&key=eceff76f289a4da6a6eae5730c09d9b7
//Daily -  16 Day Weather Forecast API (1 day interval)