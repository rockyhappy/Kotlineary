package com.devrachit.kotlineary.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.ItemModelDto

@ExperimentalMaterial3Api
@Composable
fun ItemDetailBottomSheet(
    itemDetails: ItemModelDto?,
    onDismissRequest: () -> Unit
) {
    BottomSheetScaffold(
        sheetContent = {

                    Column(modifier = Modifier.padding(16.dp).background(Color.White)) {
                        Text(text = itemDetails?.title ?: "Title", )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Ready in ${itemDetails?.readyInMinutes} minutes")
                        // Add more fields as needed
                    }
        },
        scaffoldState = rememberBottomSheetScaffoldState(),
        sheetPeekHeight = 500.dp,
        content = {
        },
        containerColor = Color.White,
        sheetContainerColor = Color.White,

    )
}
