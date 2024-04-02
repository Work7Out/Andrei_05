package com.propokeignintion.cardrules.ui.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.propokeignintion.cardrules.ui.theme.brushYellow
import com.propokeignintion.cardrules.ui.theme.white


@Composable
fun CustomButton20dp(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    Box(modifier = modifier
        .clip(shape = RoundedCornerShape(15.dp))
        .clickable (onClick = onClick)
        .fillMaxWidth()
        .background(brush = brushYellow)
        .padding(vertical = 20.dp)) {
        Text(
            modifier = modifier
                .align(alignment = Alignment.Center),
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center,
                color = white
            )
        )
    }
}