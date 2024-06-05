package com.devrachit.kotlineary.presentation.Screens.LoginScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.common.Constants.CustomFontFamily
import com.devrachit.kotlineary.ui.theme.primaryColor

@Composable
fun CustomButton(text: String, onClick: () -> Unit, modifier : Modifier = Modifier) {
    OutlinedButton(
        onClick = { onClick.invoke() },
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.Transparent),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black,
            containerColor = primaryColor,
        ),
        border = BorderStroke(2.dp, primaryColor)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.coolicon),
            tint = Color.White,
            modifier = Modifier
                .height(36.dp)
                .padding(end = 10.dp),
            contentDescription = null)
        Text(
            text = text,
            color = Color.White,
            fontFamily = CustomFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}