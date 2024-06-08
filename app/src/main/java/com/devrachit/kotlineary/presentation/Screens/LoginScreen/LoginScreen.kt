package com.devrachit.kotlineary.presentation.Screens.LoginScreen

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.common.Constants.CustomFontFamily
import com.devrachit.kotlineary.presentation.Screens.LoginScreen.components.BgImage
import com.devrachit.kotlineary.presentation.Screens.LoginScreen.components.CustomButton
import com.devrachit.kotlineary.presentation.Screens.LoginScreen.components.Heading
import com.devrachit.kotlineary.presentation.Screens.LoginScreen.components.HeadingMain
import com.devrachit.kotlineary.presentation.Screens.LoginScreen.components.HeadingSmall
import com.devrachit.kotlineary.presentation.navigation.AppScreens

@Composable
fun LoginScreen(navController: NavController) {
    val viewModel :LoginScreenViewModel= hiltViewModel()
    val onLoginClick :()->Unit = {
        navController.navigate(AppScreens.HomeScreen.route)
    }
    val activity = LocalContext.current as? Activity
    LaunchedEffect(key1=true) {
        activity?.window?.let { window ->
            WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        }
    }
    Scaffold (
        modifier=Modifier.fillMaxSize(),
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        )
        {
            Log.d("LoginScreen", it.toString())
            BgImage()
            Heading(text = stringResource(id =R.string.welcomeTo), modifier = Modifier.padding(start = 20.dp))
            HeadingMain(text = stringResource(id =R.string.Reciipiie), modifier = Modifier.padding(start = 20.dp))
            HeadingSmall(text = stringResource(id = R.string.pleaseSignIn), modifier = Modifier.padding(start = 20.dp))
            CustomButton(
                text = stringResource(id = R.string.continueWithGoogle),
                onClick = {onLoginClick.invoke()},
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 50.dp, start = 20.dp, end = 20.dp)
            )
        }

    }
}