package com.devrachit.kotlineary.presentation.Screens.LoginScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    val viewModel :LoginScreenViewModel= hiltViewModel()
    Text(text ="Login Screen", fontSize = 100.sp)

}