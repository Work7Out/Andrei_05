package com.propokeignintion.cardrules.ui

import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.propokeignintion.cardrules.R
import com.propokeignintion.cardrules.ui.theme.black
import com.propokeignintion.cardrules.ui.theme.brushYellow
import com.propokeignintion.cardrules.ui.theme.white

@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    isSound: Boolean,
    mediaPlayer: MediaPlayer,
) {
    val configuration = LocalConfiguration.current
    val horizontalPadding = when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            60.dp
        }
        else -> {
            16.dp
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column (
            modifier = modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(onClick = {
                    if (isSound) {
                        mediaPlayer.start()
                    }
                    navController.popBackStack()
                }) {
                    Image(
                        modifier = modifier.size(40.dp),
                        painter = painterResource(id = R.drawable.back_bt),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds
                    )
                }
                Text(
                    modifier = modifier,
                    text = stringResource(id = R.string.info),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.krona_one)),
                        fontWeight = FontWeight(400),
                        textAlign = TextAlign.Center,
                        color = white
                    )
                )
                TextButton(onClick = {}) {
                    Image(
                        modifier = modifier.size(40.dp),
                        painter = painterResource(id = R.drawable.system_bt),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            Spacer(modifier = modifier.height(20.dp))
            Column(
                modifier = modifier
                    .padding(vertical = 16.dp, horizontal = horizontalPadding)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .fillMaxWidth()
                    .background(brush = brushYellow)
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                Text(
                    modifier = modifier,
                    text = stringResource(id = R.string.info_ct),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.krona_one)),
                        fontWeight = FontWeight(400),
                        color = black
                    )
                )
            }
        }
    }
}
