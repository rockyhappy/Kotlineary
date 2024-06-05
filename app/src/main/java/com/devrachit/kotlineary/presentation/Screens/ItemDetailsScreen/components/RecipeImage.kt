package com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeImage(imageUrl: String?) {
    val painter = rememberAsyncImagePainter(model = imageUrl)
    Image(
        painter = painter,
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp),
        contentScale = ContentScale.FillBounds,
        contentDescription = null
    )
}