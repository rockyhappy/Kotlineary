package com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devrachit.kotlineary.common.Constants.CustomFontFamily
import com.devrachit.kotlineary.common.Constants.CustomFontFamilyBold
import com.devrachit.kotlineary.ui.theme.DarkGreyColor
import com.devrachit.kotlineary.ui.theme.greyColor
import com.devrachit.kotlineary.ui.theme.primaryColor

@Composable
fun ElementCard(topic:String,decription:String) {
    Box(modifier = Modifier
        .height(70.dp)
        .width(110.dp))
    {
        Card (
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, greyColor),
            elevation = CardDefaults.cardElevation(),
        ){
            Column(
                modifier = Modifier.fillMaxSize().background(Color.White),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
            ){
                Text(
                    text=topic,
                    color= DarkGreyColor,
                    fontFamily = CustomFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    text=decription,
                    color= primaryColor,
                    fontFamily = CustomFontFamilyBold,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}
@Preview
@Composable
fun ElementCardPreview() {
    ElementCard("Ready in","25 min")
}