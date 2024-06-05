package com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun ItemDetailsScreen(navController: NavController) {
    val viewModel: ItemDetailsViewModel = hiltViewModel()
    Text(text=viewModel.allRecipes.getId().toString(), color = Color.White)
    val id = viewModel.allRecipes.id.collectAsStateWithLifecycle().value
    LaunchedEffect(key1=true) {
        viewModel.getRecipe(id)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White
    ) {
        Log.d("ItemDetailScreen", it.toString())

    }
}