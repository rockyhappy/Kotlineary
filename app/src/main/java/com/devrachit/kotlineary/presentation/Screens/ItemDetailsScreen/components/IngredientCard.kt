package com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.devrachit.kotlineary.common.Constants

@Composable
fun IngredientCard(imageurl: String, ingredientName: String) {
    Box(modifier = Modifier
        .wrapContentHeight()
        .width(86.dp)
        .background(Color.Transparent)
    )
    {
        Card(
            shape = CircleShape
        ) {
            Image(
                painter = rememberAsyncImagePainter(model= imageurl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(86.dp),
                )
        }
        Text(
            text = ingredientName,
            fontFamily = Constants.CustomFontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.background(Color.Transparent).fillMaxWidth().align(Alignment.BottomCenter).padding(top=92.dp),
            color= Color.Black,
            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
            maxLines = 1,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

    }

}

@Preview
@Composable
fun IngredientCardPreview() {
    IngredientCard(
        imageurl = "https://www.themealdb.com/images/ingredients/Chicken.png",
        ingredientName = "Chicken"
    )
}