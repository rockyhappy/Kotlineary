package com.devrachit.kotlineary.presentation.Screens.HomeScreen

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.HeadingHome
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.HeadingHomeSmall
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.RecipeCardMain
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.RecipeCardPopular
import com.devrachit.kotlineary.presentation.Screens.HomeScreen.components.updateStatusBarTheme

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeScreenViewModel = hiltViewModel()
    val activity = LocalContext.current as? Activity
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
                .padding(top = 40.dp, start = 30.dp, end = 30.dp)
                .background(Color.White)
        ) {
            item {
                HeadingHome(text = stringResource(R.string.homeHead))
                HeadingHomeSmall(text = stringResource(id = R.string.homeSubHead))
            }
        }
    }

}
