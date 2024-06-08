package com.devrachit.kotlineary.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

import androidx.navigation.compose.rememberNavController
import com.devrachit.kotlineary.presentation.navigation.NavHost
import com.devrachit.kotlineary.ui.theme.KotlinearyTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor= Color.White.toArgb()
        window.navigationBarColor = Color.White.toArgb()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            KotlinearyTheme {
                val navController = rememberNavController()
                    NavHost(navHostController = navController)
            }
        }
    }

}

