package com.example.myapplaunchweather.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplaunchweather.view.login.LoginScreen
import com.example.myapplaunchweather.view.onboarding.OnboardingScreen
import com.example.myapplaunchweather.view.user.UserFormScreen
import com.example.myapplaunchweather.view.user.UserListScreen
import com.example.myapplaunchweather.view.weather.WeatherScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Onboarding.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }

        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Screen.UserList.route) {
            UserListScreen(navController = navController)
        }

        composable(route = Screen.UserForm.route) {
            UserFormScreen(navController = navController)
        }

        composable(route = Screen.Weather.route) {
            WeatherScreen(navController = navController)
        }
    }
}