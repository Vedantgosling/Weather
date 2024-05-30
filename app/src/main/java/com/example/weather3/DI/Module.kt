package com.example.weather3.DI

import com.example.weather3.Data.ForecastAPI
import com.example.weather3.Domain.WeatherRepository
import com.example.weather3.Domain.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides// it provides DI, Hilt will search in its modules and then return
    @Singleton
    fun providesWeatherForecastApi(): ForecastAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ForecastAPI.BASE_URL)
            .build()
            .create(ForecastAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesWeatherForecastRepository(ForecastApi: ForecastAPI): WeatherRepository {
        return RepositoryImpl(ForecastApi)
    }

}