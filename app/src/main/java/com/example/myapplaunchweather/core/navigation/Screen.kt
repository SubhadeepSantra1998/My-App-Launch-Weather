package com.example.myapplaunchweather.core.navigation

sealed class Screen(val route: String) {
    data object Onboarding : Screen(route = Routes.ONBOARDING_SCREEN)
    data object Login : Screen(route = Routes.LOGIN_SCREEN)
    data object UserList : Screen(route = Routes.USER_LIST_SCREEN)
    data object UserForm : Screen(route = Routes.USER_FORM_SCREEN)
    data object Weather : Screen(route = Routes.WEATHER_SCREEN)
}