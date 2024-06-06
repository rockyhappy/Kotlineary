package com.devrachit.kotlineary.presentation.Screens.FavoriteScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.BottomNavigationBar
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.RecipeCardMain
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.SubHeading
import com.devrachit.kotlineary.presentation.navigation.AppScreens

@ExperimentalMaterial3Api
@Composable
fun FavoriteScreen(navController: NavController) {
    val viewModel: FavoriteScreenViewModel = hiltViewModel()
    val items = viewModel.favoriteRecipes.collectAsStateWithLifecycle().value
    LaunchedEffect(key1 = true) {
        viewModel.getFavoriteRecipes()
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                currentRoute = navController.currentDestination?.route ?: ""
            )
        }
    ) {
        Log.d("FavoriteScreen", it.toString())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp, start = 16.dp, end = 16.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                SubHeading(
                    text = "Favorite Items",
                    modifier = Modifier.padding(top = 60.dp, bottom = 10.dp)
                )
            }
            if (!items.isEmpty())
                items(items.size) {
                    RecipeCardMain(
                        subtitle = "Ready in ${items[it].readyInMinutes} minutes",
                        title = items[it].title,
                        imageUrl = items[it].image ?: ""
                    ) {
                        viewModel.allRecipes.setFavoriteRecipe(items[it])
                        navController.navigate(AppScreens.FavoriteItemDetailsScreen.route)
                    }

                }
        }
    }
}