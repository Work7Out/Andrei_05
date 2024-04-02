package com.propokeignintion.cardrules.ui

import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.propokeignintion.cardrules.R
import com.propokeignintion.cardrules.domain.utils.TEST_SCREEN
import com.propokeignintion.cardrules.ui.theme.white
import com.propokeignintion.cardrules.ui.uikit.CustomButtonImageText

@Composable
fun ListTestsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    isSound: Boolean,
    mediaPlayer: MediaPlayer,
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val horizontalPadding = if (isLandscape) {
        (screenWidth - screenWidth / 2.19f) / 2
    } else {
        20.dp
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
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            if (isLandscape) {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    TextButton(
                        modifier = modifier.align(Alignment.CenterStart),
                        onClick = {
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
                        modifier = modifier.align(Alignment.Center),
                        text = stringResource(id = R.string.list_of_tests),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            textAlign = TextAlign.Center,
                            color = white
                        )
                    )
                }
            } else {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
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
                    Spacer(modifier = modifier.width(10.dp))
                    Text(
                        modifier = modifier,
                        text = stringResource(id = R.string.list_of_tests),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            textAlign = TextAlign.Center,
                            color = white
                        )
                    )
                }
            }
            Spacer(modifier = modifier.height(20.dp))
            Column(
                modifier = modifier
                    .padding(vertical = 16.dp, horizontal = horizontalPadding)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
            ) {
                CustomButtonImageText(
                    title = stringResource(id = R.string.rule_name_1),
                    image = R.drawable.cards,
                    onClick = {
                        if (isSound) {
                            mediaPlayer.start()
                        }
                        navController.navigate("$TEST_SCREEN/1")
                    }
                )
                Spacer(modifier = modifier.height(5.dp))
                CustomButtonImageText(
                    title = stringResource(id = R.string.rule_name_2),
                    image = R.drawable.peoples,
                    onClick = {
                        if (isSound) {
                            mediaPlayer.start()
                        }
                        navController.navigate("$TEST_SCREEN/2")
                    }
                )
                Spacer(modifier = modifier.height(5.dp))
                CustomButtonImageText(
                    title = stringResource(id = R.string.rule_name_3),
                    image = R.drawable.ace,
                    onClick = {
                        if (isSound) {
                            mediaPlayer.start()
                        }
                        navController.navigate("$TEST_SCREEN/3")
                    }
                )
                Spacer(modifier = modifier.height(5.dp))
                CustomButtonImageText(
                    title = stringResource(id = R.string.rule_name_4),
                    image = R.drawable.aces,
                    onClick = {
                        if (isSound) {
                            mediaPlayer.start()
                        }
                        navController.navigate("$TEST_SCREEN/4")
                    }
                )
                Spacer(modifier = modifier.height(5.dp))
                CustomButtonImageText(
                    title = stringResource(id = R.string.rule_name_5),
                    image = R.drawable.spades,
                    onClick = {
                        if (isSound) {
                            mediaPlayer.start()
                        }
                        navController.navigate("$TEST_SCREEN/5")
                    }
                )
            }
        }
    }
}
