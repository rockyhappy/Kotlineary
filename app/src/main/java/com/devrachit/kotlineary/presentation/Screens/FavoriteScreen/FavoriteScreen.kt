package com.devrachit.kotlineary.presentation.Screens.FavoriteScreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun FavoriteScreen(navController: NavController) {
    val viewModel : FavoriteScreenViewModel = hiltViewModel()

}