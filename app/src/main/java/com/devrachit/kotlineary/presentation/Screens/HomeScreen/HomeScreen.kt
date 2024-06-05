package com.devrachit.kotlineary.presentation.Screens.HomeScreen

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.HeadingHome
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.HeadingHomeSmall
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.LoadingDialog
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.RecipeCardMain
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.RecipeCardPopular
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.SearchBar
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.SubHeading
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.updateStatusBarTheme

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeScreenViewModel = hiltViewModel()
    val searchQuery = viewModel.searchQuery.collectAsStateWithLifecycle().value
    val activity = LocalContext.current as? Activity
    val loading = viewModel.loading.collectAsStateWithLifecycle()
    LaunchedEffect(key1=true) {
            activity?.window?.let { window ->
                WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
            }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White
    ) {
        Log.d("HomeScreen", it.toString())
        LazyColumn(
            modifier = Modifier
                .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                HeadingHome(text = stringResource(R.string.homeHead))
                HeadingHomeSmall(text = stringResource(id = R.string.homeSubHead))
                SearchBar(
                    searchQuery = searchQuery,
                    onValueChange = { newValue -> viewModel.setSearchQuery(newValue) },
                    modifier = Modifier.padding(top = 20.dp)
                )
                SubHeading(text = stringResource(id =R.string.popularRecipes), modifier=Modifier.padding(top=20.dp))
                LazyRow(
                    modifier = Modifier.padding(top = 11.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                )
                {
                    items(5) {
                        RecipeCardPopular(subtitle = "Ready in 25 min", title = "Shahi Paneer", imageUrl = "https://picsum.photos/300/200", onClick = {})
                    }
                }
                SubHeading(text = stringResource(id =R.string.seeAll), modifier=Modifier.padding(top=20.dp))
            }
            items(7)
            {
                RecipeCardMain(subtitle = "Ready in 25 min", title = "Shahi Paneer", imageUrl = "https://picsum.photos/300/300", onClick = {})
            }
        }
    }
    if (loading.value) {
        LoadingDialog(isShowingDialog = true)
    }
    else{
        LoadingDialog(isShowingDialog =false)
    }

}
