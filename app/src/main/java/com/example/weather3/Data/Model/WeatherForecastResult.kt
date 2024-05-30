package com.example.weather3.Data.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class WeatherForecastResult(
    val city_name: String,
    val country_code: String,
    val data: List<Data>,
    val lat: String,
    val lon: String,
    val state_code: String,
    val timezone: String
): Parcelable