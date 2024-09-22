package com.example.myapplaunchweather.view.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplaunchweather.core.common.Resource
import com.example.myapplaunchweather.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherUiState())
    val state: StateFlow<WeatherUiState> = _state.asStateFlow()

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            repository.getWeatherData().onStart {
                _state.update {
                    it.copy(
                        isLoading = true
                    )
                }
            }.onEach { result ->
                _state.value = when (result) {
                    is Resource.Loading -> {
                        _state.value.copy(
                            isLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _state.value.copy(
                            isLoading = false,
                            data = result.data?.current
                        )
                    }

                    is Resource.Error -> {
                        _state.value.copy(
                            isLoading = false
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}