package com.devrachit.kotlineary.presentation.navigation

sealed class AppScreens(val route: String) {
    object HomeScreen : AppScreens("HomeScreen")

    object LoginScreen : AppScreens("LoginScreen")
}