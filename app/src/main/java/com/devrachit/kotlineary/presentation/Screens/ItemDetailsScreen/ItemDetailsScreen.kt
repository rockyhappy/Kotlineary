package com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.LoadingDialog
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.ElementCardCombo
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.ExpandableContainer
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.FavoriteButton
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.IngredientCard
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.RecipeImage
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.SubHeadingItemDetail
import com.devrachit.kotlineary.ui.theme.DarkGreyColor

@Composable
fun ItemDetailsScreen(navController: NavController) {
    val viewModel: ItemDetailsViewModel = hiltViewModel()
    Text(text = viewModel.allRecipes.getId().toString(), color = Color.White)
    val id = viewModel.allRecipes.id.collectAsStateWithLifecycle().value
    val recipe = viewModel.recipe.collectAsStateWithLifecycle().value
    val isFavorite = remember { mutableStateOf(false) }
    val loading = viewModel.loading.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = true) {
        viewModel.getRecipe(id)
    }
    val ScrollState = remember { ScrollState(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
    ) {
        Log.d("ItemDetailScreen", it.toString())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom=20.dp)
                .verticalScroll(ScrollState)
        )
        {
            RecipeImage(imageUrl = recipe?.image)
            FavoriteButton(
                isFavorite = isFavorite.value,
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                isFavorite.value = !isFavorite.value
            }
            ElementCardCombo(
                title1 = "Ready in",
                title2 = "Serving",
                title3 = "Price/Serving",
                description1 = "${recipe?.readyInMinutes} min",
                description2 = "${recipe?.servings} people",
                description3 = "${recipe?.pricePerServing}"
            )
            SubHeadingItemDetail(
                text = "Ingredients",
                modifier = Modifier.padding(top = 480.dp, start = 16.dp)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 520.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(16.dp)
            )
            {
                if (recipe?.extendedIngredients != null)
                    items(recipe?.extendedIngredients!!.size) {
                        println(recipe.extendedIngredients[it].image)
                        IngredientCard(
                            imageurl = "https://spoonacular.com/recipes/" + recipe.extendedIngredients[it].image,
                            ingredientName = recipe.extendedIngredients[it].name
                        )
                    }
            }
            SubHeadingItemDetail(
                text = "Instructions",
                modifier = Modifier.padding(top = 660.dp, start = 16.dp)
            )
            Column(
                modifier = Modifier.padding(top = 700.dp)
            ) {
                Text(
                    text = recipe?.instructions ?: "",
                    modifier = Modifier.padding(top = 20.dp, start = 16.dp, end = 16.dp),
                    color = DarkGreyColor
                )
                SubHeadingItemDetail(
                    text = "Equipment",
                    modifier = Modifier.padding(top = 20.dp, start = 16.dp)
                )
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 16.dp, end = 16.dp),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(
                        16.dp
                    )
                )
                {
                    items(3) {
                        IngredientCard(
                            imageurl = "https://spoonacular.com/recipes/balsamic-vinegar.jpg",
                            ingredientName = "Equipment"
                        )
                    }
                }
                SubHeadingItemDetail(
                    text = "Quick Summary",
                    modifier = Modifier.padding(top = 20.dp, start = 16.dp)
                )
                Text(
                    text = recipe?.summary ?: "",
                    modifier = Modifier.padding(top = 20.dp, start = 16.dp, end = 16.dp,bottom=20.dp),
                    color = DarkGreyColor
                )
                ExpandableContainer(heading = "Nutrition", description = stringResource(id = R.string.sample))
                ExpandableContainer(heading = "Bad for health Nutrition", description = stringResource(id = R.string.sample))
                ExpandableContainer(heading = "Good for health Nutrition", description = stringResource(id = R.string.sample))

            }
        }
    }
    if (loading.value) {
        LoadingDialog(isShowingDialog = true)
    } else {
        LoadingDialog(isShowingDialog = false)
    }
}