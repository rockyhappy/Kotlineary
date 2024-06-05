package com.devrachit.kotlineary.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.HomeScreen
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.ItemDetailsScreen
import com.devrachit.kotlineary.presentation.Screens.LoginScreen.LoginScreen

@ExperimentalMaterial3Api
@Composable
fun NavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = AppScreens.LoginScreen.route
    )
    {
        composable(AppScreens.HomeScreen.route)
        {
            HomeScreen(navController = navHostController)
        }
        composable(AppScreens.LoginScreen.route)
        {
            LoginScreen(navController = navHostController)
        }
        composable(AppScreens.ItemDetailsScreen.route)
        {
            ItemDetailsScreen(navController = navHostController)
        }
    }

}