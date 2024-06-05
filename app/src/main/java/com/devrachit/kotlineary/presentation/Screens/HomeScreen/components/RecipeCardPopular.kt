package com.devrachit.kotlineary.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.devrachit.kotlineary.common.Constants.CustomFontFamily

@ExperimentalMaterial3Api
@Composable
fun RecipeCardPopular(subtitle:String,title:String , imageUrl:String , onClick:()->Unit) {
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black),
        startY = sizeImage.height.toFloat()/3,  // 1/3
        endY = sizeImage.height.toFloat()
    )
    Box(
        modifier= Modifier
            .height(200.dp)
            .width(200.dp),
        contentAlignment = Alignment.BottomStart
    ){
        //Image
        //Title
        Card(
            onClick = {onClick.invoke()},
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                //Image
                //Title
                val painter= rememberAsyncImagePainter(model =imageUrl)
                Image(painter = painter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize().onGloballyPositioned { coordinates ->
                        sizeImage = coordinates.size
                    },
                    contentScale = ContentScale.FillBounds, alignment = Alignment.Center)
                Box(modifier = Modifier.matchParentSize().background(gradient))
                Text(
                    text = title,
                    color = Color.White,
                    fontFamily = CustomFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize=16.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(start=16.dp, bottom=30.dp)
                )
                Text(
                    text = subtitle,
                    color = Color.Gray,
                    fontFamily = CustomFontFamily,
                    fontSize=12.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(start=16.dp, bottom=10.dp)
                )
            }


        }
    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun RecipeCardPopularPreview() {
    RecipeCardPopular(subtitle = "Ready in 25 min", title = "Shahi Paneer", imageUrl = "https://via.placeholder.com/200", onClick = {})
}