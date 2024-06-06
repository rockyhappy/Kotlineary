package com.devrachit.kotlineary.presentation.Screens.FavoriteScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.BottomNavigationBar

@Composable
fun FavoriteScreen(navController: NavController) {
    val viewModel : FavoriteScreenViewModel = hiltViewModel()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            BottomNavigationBar(navController = navController, currentRoute = navController.currentDestination?.route ?: "")
        }
    ) {
        println(it.toString())
    }
}