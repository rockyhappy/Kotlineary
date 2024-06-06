package com.devrachit.kotlineary.presentation.Screens.HomeScreen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.common.Constants
import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.ItemModelDto
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.ElementCardCombo
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.ExpandableContainer
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.IngredientCard
import com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components.SubHeadingItemDetail
import com.devrachit.kotlineary.ui.theme.DarkGreyColor
import com.devrachit.kotlineary.ui.theme.primaryColor
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun ItemDetailBottomSheet(
    itemDetails: ItemModelDto?,
    onDismissRequest: () -> Unit
) {
    val image = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    val showIngredients = remember { mutableStateOf(false) }
    val showFullRecipe = remember { mutableStateOf(false) }
    val showSimilarRecipes = remember { mutableStateOf(false) }
    LaunchedEffect(sheetState) {
        scope.launch {
            sheetState.show()
        }
    }
    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() },
        containerColor = Color.White,
        sheetState = sheetState,

        ) {
        Box() {
            Column(
                modifier = Modifier
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = androidx.compose.ui.Alignment.Top
                )
                {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back button to close the bottom sheet",
                        modifier = Modifier.clickable {
                            onDismissRequest()
                        },
                        tint = Color.Black
                    )
                    Text(
                        text = itemDetails!!.title,
                        fontFamily = Constants.CustomFontFamilyBold,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .background(Color.Transparent)
                            .width(300.dp)
                            .padding(start = 16.dp),
                        color = Color.Black
                    )
                    Icon(
                        imageVector = if (image.value) ImageVector.vectorResource(id = R.drawable.favorite_selected) else ImageVector.vectorResource(
                            id = R.drawable.favorite_unselected
                        ),
                        contentDescription = "Favorite button to add the recipe to favorites",
                        modifier = Modifier.clickable {
                            image.value = !image.value
                        },
                        tint = primaryColor
                    )
                }
                val painter = rememberAsyncImagePainter(model = itemDetails?.image)
                Image(
                    painter = painter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null
                )
                ElementCardCombo2(
                    title1 = "Ready in",
                    title2 = "Serving",
                    title3 = "Price/Serving",
                    description1 = itemDetails?.readyInMinutes.toString(),
                    description2 = itemDetails?.servings.toString(),
                    description3 = itemDetails?.pricePerServing.toString()
                )
                CustomButton2(
                    text = "Get Ingredients  >",
                    onClick = { showIngredients.value = !showIngredients.value },
                    modifier = Modifier.padding(top = 20.dp, start = 16.dp, end = 16.dp)
                )
            }
            if (showIngredients.value)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .background(Color.White)
                        .padding(top = 0.dp)
                )
                {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = androidx.compose.ui.Alignment.Top
                        )
                        {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back button to close the bottom sheet",
                                modifier = Modifier.clickable {
                                    showIngredients.value = !showIngredients.value
                                },
                                tint = Color.Black
                            )
                            Text(
                                text = itemDetails!!.title,
                                fontFamily = Constants.CustomFontFamilyBold,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .width(300.dp)
                                    .padding(start = 16.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = if (image.value) ImageVector.vectorResource(id = R.drawable.favorite_selected) else ImageVector.vectorResource(
                                    id = R.drawable.favorite_unselected
                                ),
                                contentDescription = "Favorite button to add the recipe to favorites",
                                modifier = Modifier.clickable {
                                    image.value = !image.value
                                },
                                tint = primaryColor
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                        )
                        {
                            Text(
                                text = "Ingredients",
                                fontFamily = Constants.CustomFontFamilyBold,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .padding(start = 16.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = Color.Black
                            )

                        }

                        //here will be the lazyGrid 
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(430.dp)
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        ) {
                            items(itemDetails?.extendedIngredients?.size ?: 0) {
                                IngredientCard2(
                                    imageurl = "https://spoonacular.com/recipes/" + itemDetails?.extendedIngredients?.get(
                                        it
                                    )?.image,
                                    ingredientName = itemDetails?.extendedIngredients?.get(it)?.name
                                        ?: "",
                                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                                )
                            }
                        }
                        CustomButton2(
                            text = "Get full recipe >",
                            onClick = { showFullRecipe.value = !showFullRecipe.value },
                            modifier = Modifier.padding(top = 20.dp, start = 16.dp, end = 16.dp)
                        )
                    }

                }
            if (showFullRecipe.value) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .background(Color.White)
                        .padding(top = 0.dp)
                )
                {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = androidx.compose.ui.Alignment.Top
                        )
                        {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back button to close the bottom sheet",
                                modifier = Modifier.clickable {
                                    showFullRecipe.value = !showFullRecipe.value
                                },
                                tint = Color.Black
                            )
                            Text(
                                text = itemDetails!!.title,
                                fontFamily = Constants.CustomFontFamilyBold,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .width(300.dp)
                                    .padding(start = 16.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = if (image.value) ImageVector.vectorResource(id = R.drawable.favorite_selected) else ImageVector.vectorResource(
                                    id = R.drawable.favorite_unselected
                                ),
                                contentDescription = "Favorite button to add the recipe to favorites",
                                modifier = Modifier.clickable {
                                    image.value = !image.value
                                },
                                tint = primaryColor
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                                .height(50.dp)
                                .clickable { showFullRecipe.value = !showFullRecipe.value }
                        )
                        {
                            Text(
                                text = "Ingredients",
                                fontFamily = Constants.CustomFontFamilyBold,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .padding(start = 16.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = Color.Black
                            )

                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                        )
                        {
                            Text(
                                text = "Full Recipe",
                                fontFamily = Constants.CustomFontFamilyBold,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .padding(start = 16.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = Color.Black
                            )

                        }
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(380.dp)
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        )
                        {
                            item{
                                Text(
                                    text = "Instructions",
                                    fontFamily = Constants.CustomFontFamilyBold,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Normal,
                                    modifier = Modifier.background(Color.Transparent),
                                    color= Color.Black
                                )
                                Text(
                                    text = itemDetails?.instructions ?: "",
                                    modifier = Modifier.padding(top = 10.dp, start = 16.dp,end=16.dp,bottom=10.dp),
                                    color = DarkGreyColor
                                )
                                Text(
                                    text = "Equipment",
                                    fontFamily = Constants.CustomFontFamilyBold,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Normal,
                                    modifier = Modifier.background(Color.Transparent),
                                    color= Color.Black
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
                                Text(
                                    text = "Quick Summary",
                                    fontFamily = Constants.CustomFontFamilyBold,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Normal,
                                    modifier = Modifier.background(Color.Transparent),
                                    color= Color.Black
                                )
                                Text(
                                    text = itemDetails?.summary ?: "",
                                    modifier = Modifier.padding(top = 20.dp, start = 16.dp, end = 16.dp,bottom=20.dp),
                                    color = DarkGreyColor
                                )
                                ExpandableContainer(heading = "Nutrition", description = stringResource(id = R.string.sample))
                                ExpandableContainer(heading = "Bad for health Nutrition", description = stringResource(id = R.string.sample))
                                ExpandableContainer(heading = "Good for health Nutrition", description = stringResource(id = R.string.sample))

                            }
                        }
                        CustomButton2(
                            text = "Get similar recipes >",
                            onClick = { showSimilarRecipes.value = !showSimilarRecipes.value },
                            modifier = Modifier.padding(top = 20.dp, start = 16.dp, end = 16.dp)
                        )
                    }
                }
            }
            if(showSimilarRecipes.value)
            {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .background(Color.White)
                        .padding(top = 0.dp)
                )
                {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = androidx.compose.ui.Alignment.Top
                        )
                        {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back button to close the bottom sheet",
                                modifier = Modifier.clickable {
                                    showSimilarRecipes.value = !showSimilarRecipes.value
                                },
                                tint = Color.Black
                            )
                            Text(
                                text = itemDetails!!.title,
                                fontFamily = Constants.CustomFontFamilyBold,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .width(300.dp)
                                    .padding(start = 16.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = if (image.value) ImageVector.vectorResource(id = R.drawable.favorite_selected) else ImageVector.vectorResource(
                                    id = R.drawable.favorite_unselected
                                ),
                                contentDescription = "Favorite button to add the recipe to favorites",
                                modifier = Modifier.clickable {
                                    image.value = !image.value
                                },
                                tint = primaryColor
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                                .height(50.dp)
                                .clickable {
                                    showFullRecipe.value = !showFullRecipe.value
                                    showSimilarRecipes.value = !showSimilarRecipes.value
                                }
                        )
                        {
                            Text(
                                text = "Ingredients",
                                fontFamily = Constants.CustomFontFamilyBold,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .padding(start = 16.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = Color.Black
                            )

                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                                .height(50.dp)
                                .clickable {

                                    showSimilarRecipes.value = !showSimilarRecipes.value
                                }
                        )
                        {
                            Text(
                                text = "Full Recipe",
                                fontFamily = Constants.CustomFontFamilyBold,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .padding(start = 16.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = Color.Black
                            )

                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                                .height(50.dp)
                        )
                        {
                            Text(
                                text = "Similar Recipes",
                                fontFamily = Constants.CustomFontFamilyBold,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .padding(start = 16.dp),
                                color = Color.Black
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = Color.Black
                            )

                        }
                        LazyColumn(
                            modifier=Modifier.fillMaxWidth().height(380.dp).padding(top=16.dp,start=16.dp,end=16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(5){
                                RecipeCardMain(
                                    subtitle = "Ready in 15 min",
                                    title = "Shahi Paneer",
                                    imageUrl = "https://spoonacular.com/recipeImages/715594-312x231.jpg",
                                    onClick = {}
                                )
                            }
                        }

                    }
                }

            }

        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewItemDetailBottomSheet() {
    ItemDetailBottomSheet(
        itemDetails = ItemModelDto(
            id = 1,
            title = "Shahi Panner",
            readyInMinutes = 30,
            image = "",
            imageType = "",
            instructions = "",
            summary = "",
            vegan = false,
            vegetarian = false,
            veryHealthy = false,
            veryPopular = false,
            weightWatcherSmartPoints = 0,
            aggregateLikes = 0,
            analyzedInstructions = emptyList(),
            cheap = false,
            cookingMinutes = 0,
            creditsText = "",
            cuisines = emptyList(),
            dairyFree = false,
            diets = emptyList(),
            dishTypes = emptyList(),
            extendedIngredients = emptyList(),
            gaps = "",
            glutenFree = false,
            healthScore = 0,
            occasions = emptyList(),
            originalId = null,
            preparationMinutes = 0,
            pricePerServing = 60.0,
            servings = 5,
            sourceName = "",
            sourceUrl = "",
            spoonacularScore = 0.0,
            sustainable = false,
            lowFodmap = false,
        ),
        onDismissRequest = {}
    )
}