package com.devrachit.kotlineary.presentation.Screens.HomeScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel :HomeScreenViewModel = hiltViewModel()
    Text(text ="Home Screen")
}