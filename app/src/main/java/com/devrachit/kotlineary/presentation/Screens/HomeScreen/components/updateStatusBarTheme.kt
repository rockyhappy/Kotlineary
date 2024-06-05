package com.devrachit.kotlineary.presentation.Screens.HomeScreen.components

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun updateStatusBarTheme(isLightTheme: Boolean) {
    val activity = LocalContext.current as? Activity
    activity?.window?.let { window ->
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = isLightTheme
    }
}