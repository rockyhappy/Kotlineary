package com.devrachit.kotlineary.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.devrachit.kotlineary.common.Constants.CustomFontFamilyBold

@Composable
fun SubHeading(text:String, modifier: Modifier = Modifier)
{
    Text(
        text = text,
        fontFamily = CustomFontFamilyBold,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        modifier = modifier.background(Color.Transparent),
        color=Color.Black
    )
}