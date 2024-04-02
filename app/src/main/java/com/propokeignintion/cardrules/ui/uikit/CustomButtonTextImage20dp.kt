package com.propokeignintion.cardrules.ui.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.propokeignintion.cardrules.R
import com.propokeignintion.cardrules.ui.theme.brushYellow
import com.propokeignintion.cardrules.ui.theme.white


@Composable
fun CustomButtonTextImage20dp(
    modifier: Modifier = Modifier,
    title: String,
    image: Int,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    Box(modifier = modifier
        .clip(shape = RoundedCornerShape(15.dp))
        .clickable { if (isEnabled) onClick() }
        .fillMaxWidth()
        .background(brush = brushYellow)
        .padding(vertical = 5.dp)) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterStart)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.krona_one)),
                    fontWeight = FontWeight(400),
                    color = if (isEnabled) white else white.copy(alpha = 0.5f)
                )
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = image),
                contentDescription = "",
                tint = if (isEnabled) white else white.copy(alpha = 0.5f),
            )
        }
    }
}