package com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ElementCardCombo(
    title1:String,
    title2:String,
    title3: String,
    description1: String,
    description2: String,
    description3: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top=390.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        ElementCard(topic = title1, decription = description1)
        ElementCard(topic = title2, decription = description2)
        ElementCard(topic = title3, decription = description3)
    }

}