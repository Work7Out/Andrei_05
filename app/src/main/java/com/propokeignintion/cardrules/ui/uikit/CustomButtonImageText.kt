package com.propokeignintion.cardrules.ui.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.propokeignintion.cardrules.ui.theme.brushYellow
import com.propokeignintion.cardrules.ui.theme.white


@Composable
fun CustomButtonImageText(
    modifier: Modifier = Modifier,
    title: String,
    image: Int,
    onClick: () -> Unit
) {
    Box(modifier = modifier
        .clip(shape = RoundedCornerShape(15.dp))
        .clickable(onClick = onClick)
        .fillMaxWidth()
        .background(brush = brushYellow)
        .padding(vertical = 10.dp)) {
        Row (
            modifier = modifier
                .align(alignment = Alignment.CenterStart)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = modifier.size(30.dp),
                painter = painterResource(id = image),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = modifier.width(10.dp))
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = white
                )
            )
        }
    }
}