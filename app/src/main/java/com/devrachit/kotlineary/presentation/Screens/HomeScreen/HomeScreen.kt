package com.devrachit.kotlineary.presentation.Screens.HomeScreen

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.BottomNavigationBar
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.HeadingHome
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.HeadingHomeSmall
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.ItemDetailBottomSheet
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.LoadingDialog
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.RecipeCardMain
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.RecipeCardPopular
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.SearchBar
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.SearchBar2
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.SubHeading
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.updateStatusBarTheme
import com.devrachit.kotlineary.presentation.navigation.AppScreens
import com.devrachit.kotlineary.ui.theme.DarkGreyColor
import com.devrachit.kotlineary.ui.theme.primaryColor
import kotlin.random.Random

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeScreenViewModel = hiltViewModel()
    val searchQuery = viewModel.searchQuery.collectAsStateWithLifecycle().value
    val activity = LocalContext.current as? Activity
    val loading = viewModel.loading.collectAsStateWithLifecycle()
    val recipes = viewModel.sharedModel.recipes.collectAsStateWithLifecycle().value
    val allRecipe = viewModel.allRecipeModel.recipes.collectAsStateWithLifecycle().value
    val searchResults = viewModel.allRecipeModel.searchRecipe.collectAsStateWithLifecycle().value
    val selectedItemDetails = viewModel.searchItemDetails.collectAsStateWithLifecycle().value
    val deployBottomSheet = remember { mutableStateOf(false) }
    val isSearchFieldFocused = rememberSaveable { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }
    val focused by interactionSource.collectIsFocusedAsState()

    val onItemClick: (id: Int) -> Unit = { id ->
        viewModel.allRecipeModel.setId(id)
        navController.navigate(AppScreens.ItemDetailsScreen.route)
    }
    val onItemBottomSheetClick: (id: Int) -> Unit = { id ->
        viewModel.allRecipeModel.setId(id)
        viewModel.getRecipe(id)
        deployBottomSheet.value = true

    }

    LaunchedEffect(key1 = true) {
        activity?.window?.let { window ->
            WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars =
                true
        }
        viewModel.getRecipe()
        viewModel.getAllRecipes()
    }



    if (searchQuery.isNotEmpty()) {
        // Show search results
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.White,
        ) {
            Log.d("HomeScreen", it.toString())
            LazyColumn(
                modifier = Modifier
                    .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 10.dp)
                    .background(Color.White),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    SearchBar2(
                        searchQuery = searchQuery,
                        onValueChange = { newValue -> viewModel.setSearchQuery(newValue) },
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .focusRequester(focusRequester)
                            .focusable(interactionSource = interactionSource),
                        onDismiss = { viewModel.setSearchQuery("") }
                    )
                }
                searchResults?.let { resource ->
                    when (resource) {
                        is Resource.Success -> {
                            items(resource.data!!.results.size) { index ->
                                val recipe = resource.data!!.results[index]
                                RecipeCardMain(
                                    subtitle = "Ready in ${Random.nextInt((180 - 45) / 5 + 1) * 5 + 45} min",
                                    title = recipe.title,
                                    imageUrl = recipe.image,
                                    onClick = {
                                        onItemBottomSheetClick(recipe.id)
                                    }
                                )
                            }
                        }

                        is Resource.Error -> {
                            item {
                                Text(text = "Error: ${resource.message}")
                            }
                        }

                        is Resource.Loading -> {
                            item {
                                CircularProgressIndicator(color = primaryColor)
                            }
                        }
                    }
                }
            }
        }
    } else {
        // Show home screen widgets
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
            Log.d("HomeScreen", it.toString())
            LazyColumn(
                modifier = Modifier
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp, bottom = 10.dp)
                    .background(Color.White),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = it
            ) {
                item {
                    HeadingHome(text = stringResource(R.string.homeHead))
                    HeadingHomeSmall(text = stringResource(id = R.string.homeSubHead))
                    SearchBar(
                        searchQuery = searchQuery,
                        onValueChange = { newValue -> viewModel.setSearchQuery(newValue) },
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .focusRequester(focusRequester)
                            .focusable(interactionSource = interactionSource),

                        )
                    SubHeading(
                        text = stringResource(id = R.string.popularRecipes),
                        modifier = Modifier.padding(top = 20.dp)
                    )
                    LazyRow(
                        modifier = Modifier
                            .padding(top = 11.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        recipes?.let { resource ->
                            when (resource) {
                                is Resource.Success -> {
                                    items(resource.data?.recipes!!.size) {
                                        RecipeCardPopular(
                                            subtitle = "Ready in ${recipes.data!!.recipes[it].readyInMinutes} min",
                                            title = recipes.data!!.recipes[it].title,
                                            imageUrl = recipes.data!!.recipes[it].image,
                                            onClick = {
                                                onItemClick(recipes.data!!.recipes[it].id)
                                            }
                                        )
                                    }
                                }

                                is Resource.Error -> {
                                    item {
                                        Text(text = "Error: ${resource.message}")
                                    }
                                }

                                is Resource.Loading -> {
                                    item {
                                        CircularProgressIndicator(color = primaryColor)
                                    }
                                }
                            }
                        }
                    }
                    SubHeading(
                        text = stringResource(id = R.string.seeAll),
                        modifier = Modifier.padding(top = 20.dp)
                    )
                }
                allRecipe?.let { resource ->
                    when (resource) {
                        is Resource.Success -> {
                            items(resource.data!!.number) {
                                RecipeCardMain(
                                    subtitle = "Ready in ${Random.nextInt((180 - 45) / 5 + 1) * 5 + 45} min",
                                    title = allRecipe.data!!.results[it].title,
                                    imageUrl = allRecipe.data!!.results[it].image,
                                    onClick = {
                                        onItemClick(allRecipe.data!!.results[it].id)
                                    }
                                )
                            }
                        }

                        is Resource.Error -> {
                            item {
                                Text(text = "Error: ${resource.message}")
                            }
                        }

                        is Resource.Loading -> {
                            item {
                                CircularProgressIndicator(color = primaryColor)
                            }
                        }
                    }
                }
            }
        }
    }
    if (deployBottomSheet.value && selectedItemDetails != null) {
        ItemDetailBottomSheet(
            itemDetails = selectedItemDetails,
            onDismissRequest = { deployBottomSheet.value = false },
            recipeModel = viewModel.sharedModel.recipes.collectAsStateWithLifecycle().value
        )

    }

    if (loading.value) {
        LoadingDialog(isShowingDialog = true)
    } else {
        LoadingDialog(isShowingDialog = false)
    }
}

