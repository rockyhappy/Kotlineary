package com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ItemDetailsScreen(navController: NavController) {
    val viewModel: ItemDetailsViewModel = hiltViewModel()
    Text(text=viewModel.allRecipes.getId().toString(), color = Color.White)


}