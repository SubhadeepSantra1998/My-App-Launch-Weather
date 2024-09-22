package com.example.myapplaunchweather.view.onboarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplaunchweather.core.navigation.Screen
import com.example.myapplaunchweather.domain.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _startDestination: MutableState<String> = mutableStateOf(Screen.Login.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readLoginState().collect { completed ->
                if (completed) {
                    _startDestination.value = Screen.UserList.route
                } else {
                    _startDestination.value = Screen.Login.route
                }
            }
        }
    }
}