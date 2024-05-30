package com.example.weather3.Domain

import com.example.weather3.Data.ForecastAPI
import com.example.weather3.Data.Model.WeatherForecastResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class RepositoryImpl(
    private val api:ForecastAPI
):WeatherRepository //implementation
{
    override suspend fun getDailyForeCast(city: String): Flow<Result<WeatherForecastResult>> { //instance
        return flow {

            val weatherforecastapiresult = try {
                api.getDailyForeCast(city)
            }catch (e:Exception){
                emit(Result.Error(message = "Error Fetching data from server"))

                return@flow
            }catch (e:HttpException){
                emit(Result.Error(message = "Error Fetching data from server"))

                return@flow
            }catch (e: IOException){
                emit(Result.Error(message = "Error Fetching data from server"))

                return@flow
            }
            emit(Result.Success(data = weatherforecastapiresult))

        }
    }
}