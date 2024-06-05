package com.devrachit.kotlineary.presentation.Screens.HomeScreen.components

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
fun HeadingHomeSmall(text: String, modifier: Modifier = Modifier) {

    Text(
        text = text,
        fontSize = 12.sp,
        color = Color.Gray,
        fontFamily = Constants.CustomFontFamily,
        fontStyle = FontStyle.Normal,
        modifier = modifier.background(Color.Transparent).padding(bottom = 140.dp),
    )
}