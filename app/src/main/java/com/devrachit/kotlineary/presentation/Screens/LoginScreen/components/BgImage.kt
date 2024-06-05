package com.devrachit.kotlineary.presentation.Screens.LoginScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.devrachit.kotlineary.R

@Composable
fun BgImage() {
    Image(
        painter = painterResource(id = R.drawable.bg_login),
        contentDescription =null,
        modifier= Modifier.fillMaxSize(),
        contentScale = ContentScale.FillHeight
    )
}