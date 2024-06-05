package com.devrachit.kotlineary.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devrachit.kotlineary.ui.theme.greyColor

@Composable
fun SearchBar(
    searchQuery: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = searchQuery,
        onValueChange = onValueChange,
        placeholder = { Text("Search any recipe") },
        modifier = modifier
            .fillMaxWidth()
            .border(0.dp, Color.Black, shape = RoundedCornerShape(16.dp))
            .background(greyColor),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        maxLines = 1,
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Search Icon", tint = Color.Black)
        }
    )
}