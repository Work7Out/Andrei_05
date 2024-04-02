package com.propokeignintion.cardrules.ui.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.propokeignintion.cardrules.R
import com.propokeignintion.cardrules.ui.theme.black
import com.propokeignintion.cardrules.ui.theme.brushYellow
import com.propokeignintion.cardrules.ui.theme.green
import com.propokeignintion.cardrules.ui.theme.red
import com.propokeignintion.cardrules.ui.theme.white


@Composable
fun CustomVariantUnswear(
    modifier: Modifier = Modifier,
    title: String,
    isCorrect: Boolean,
    isChecked: Boolean?,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .border(
                width = if (isChecked == true) 2.dp else 0.dp,
                color = if (isChecked == true) if (isCorrect) green else red else Color.Transparent,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .background(brush = brushYellow)
            .padding(vertical = 5.dp)
    ) {
        Row(
            modifier = modifier
                .align(alignment = Alignment.CenterStart)
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.krona_one)),
                    fontWeight = FontWeight(400),
                    color = white
                )
            )
            Checkbox(
                colors = CheckboxDefaults.colors(
                    checkedColor = white,
                    uncheckedColor = white,
                    checkmarkColor = black
                ),
                checked = isChecked == true,
                onCheckedChange = { onClick() }
            )
        }
    }
}