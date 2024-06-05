package com.devrachit.kotlineary.presentation.Screens.LoginScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devrachit.kotlineary.common.Constants

@Composable
fun HeadingSmall(text: String, modifier: Modifier = Modifier) {

    Text(
        text = text,
        fontSize = 16.sp,
        color = Color.White,
        fontFamily = Constants.CustomFontFamily,
        fontStyle = FontStyle.Normal,
        modifier = modifier.background(Color.Transparent).padding(bottom = 140.dp),
    )
}