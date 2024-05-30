package com.example.weather3.ui.Presentation.ViewModel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather3.Domain.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.weather3.Domain.Result
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update


@HiltViewModel
class ForecastVM @Inject constructor(
    private val weatherRepository: WeatherRepository,
):ViewModel() {
    private val tag = "Weather API"

    private var _weatherforecastState = MutableStateFlow(WeatherHomeState())
    val weatherforecastState = _weatherforecastState.asStateFlow()

    init {
        getdailyforecast(city = "Katowice")

    }

    private fun getdailyforecast(city:String){
        viewModelScope.launch {
            val result = weatherRepository.getDailyForeCast(city = city).collectLatest{result->
                when(result)//result from Impl,whatever returns we check and use either error or data
                {
                    is Result.Error->{
                        Log.d(tag, "Error fetching the weather details of the app")
                    }
                    is Result.Loading->{
                        _weatherforecastState.update {
                            it.copy(
                                isLoading = true// update fun means _weatherfore.value =
                            )
                        }
                        Log.d(
                            tag,
                            "Loading Screen: The weather api forecast is still in background"
                        )
                    }
                    is Result.Success->{
                        _weatherforecastState.update {
                            it.copy(
                                isLoading = false,
                                data = result.data!! // we send data from api to state

                            )
                        }
                    }
                }

            }

        }
    }


    fun onEvent(event: WeatherHomeUiEvent)
    {
        when(event){
            is WeatherHomeUiEvent.SearchIconPressed->{
                viewModelScope.launch {
                    weatherRepository.getDailyForeCast(event.city).collectLatest { result ->
                        when (result) {
                            is Result.Error -> {
                                Log.d(tag, "Error fetching the weather details of the app")
                            }

                            is Result.Loading -> {
                                _weatherforecastState.update {
                                    it.copy(
                                        isLoading = true
                                    )
                                }
                            }

                            is Result.Success -> {
                                _weatherforecastState.update {
                                    it.copy(
                                        isLoading = false,
                                        data = result.data!!
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }
    }




}