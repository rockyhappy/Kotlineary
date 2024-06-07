package com.devrachit.kotlineary.presentation.Screens.FavoriteItemDetails

import android.text.Html
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.domain.model.Recipe
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.LoadingDialog
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.ElementCardCombo
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.ExpandableContainer
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.FavoriteButton
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.IngredientCard
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.RecipeImage
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.SubHeadingItemDetail
import com.devrachit.kotlineary.room.FavoriteRecipe
import com.devrachit.kotlineary.ui.theme.DarkGreyColor

@Composable
fun FavoriteItemDetailsScreen(navController: NavController) {
    val viewModel: FavoriteItemDetailsViewModel = hiltViewModel()
    Text(text = viewModel.allRecipes.getId().toString(), color = Color.White)
    val recipe = viewModel.allRecipes.favoriteRecipe.collectAsStateWithLifecycle().value
    val isFavorite = remember { mutableStateOf(true) }
    val ScrollState = remember { ScrollState(0) }
    val loading = viewModel.loading.collectAsStateWithLifecycle()
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
                ,
        containerColor = Color.White,
    )
    {
        Log.d("ItemDetailScreen", it.toString())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 20.dp)
//                .wrapContentHeight()
                .verticalScroll(rememberScrollState())
        )
        {
            RecipeImage(imageUrl = recipe?.image)
            FavoriteButton(
                isFavorite = isFavorite.value,
                modifier = Modifier.align(Alignment.TopEnd).padding(top=10.dp)
            ) {
                isFavorite.value = !isFavorite.value

                if(isFavorite.value)
                {
                    Toast.makeText(context, "Now add from the Main List", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    viewModel.removeRecipeFromFavorites(recipe!!.id)
                }

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
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
            items(7){
                IngredientCard(
                    imageurl = "https://spoonacular.com/recipes/balsamic-vinegar.jpg",
                    ingredientName = "Ingredient"
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
                text =  Html.fromHtml(recipe?.instructions ?: "", Html.FROM_HTML_MODE_LEGACY).toString(),
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
                horizontalArrangement = Arrangement.spacedBy(
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
                text = Html.fromHtml(recipe?.summary ?: "", Html.FROM_HTML_MODE_LEGACY).toString(),
                modifier = Modifier.padding(
                    top = 20.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 20.dp
                ),
                color = DarkGreyColor
            )
            ExpandableContainer(
                heading = "Nutrition",
                description = stringResource(id = R.string.sample)
            )
            ExpandableContainer(
                heading = "Bad for health Nutrition",
                description = stringResource(id = R.string.sample)
            )
            ExpandableContainer(
                heading = "Good for health Nutrition",
                description = stringResource(id = R.string.sample)
            )
        }
        }
    }
    if (loading.value) {
        LoadingDialog(isShowingDialog = true)
    } else {
        LoadingDialog(isShowingDialog = false)
    }
}
