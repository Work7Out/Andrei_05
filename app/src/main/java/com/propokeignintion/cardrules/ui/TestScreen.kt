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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.propokeignintion.cardrules.data.mock_data.tests
import com.propokeignintion.cardrules.ui.theme.black
import com.propokeignintion.cardrules.ui.theme.brushYellow
import com.propokeignintion.cardrules.ui.theme.green
import com.propokeignintion.cardrules.ui.theme.red
import com.propokeignintion.cardrules.ui.theme.white
import com.propokeignintion.cardrules.ui.uikit.CustomVariantUnswear

@Composable
fun TestScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    indexTest: Int,
    isSound: Boolean,
    mediaPlayer: MediaPlayer,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val test = tests.first { it.id == indexTest }
    val selectedAnswer = remember { mutableIntStateOf(-1) }
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
        Scaffold(
            modifier = modifier
                .fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
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
                            text = "${stringResource(id = R.string.test)} $indexTest",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.krona_one)),
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
                            text = "${stringResource(id = R.string.test)} $indexTest",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.krona_one)),
                                fontWeight = FontWeight(400),
                                textAlign = TextAlign.Center,
                                color = white
                            )
                        )
                    }
                }
            },
            bottomBar = {
                if (!isLandscape) {
                    Box(
                        modifier = modifier
                            .padding(16.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .fillMaxWidth()
                            .background(brush = brushYellow)
                            .padding(vertical = 20.dp)
                    ) {
                        Text(
                            modifier = modifier
                                .align(alignment = Alignment.Center),
                            text = if (selectedAnswer.intValue == -1) "" else if (selectedAnswer.intValue == test.currentAnswer) {
                                stringResource(
                                    id = R.string.correct
                                )
                            } else {
                                stringResource(R.string.wrong)
                            },
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.krona_one)),
                                fontWeight = FontWeight(400),
                                textAlign = TextAlign.Center,
                                color = if (selectedAnswer.intValue == -1) white else if (selectedAnswer.intValue == test.currentAnswer) green else red
                            )
                        )
                    }
                }
            }
        ) { innerPadding ->
            if (isLandscape) {
                Row(
                    modifier = modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        modifier = modifier
                            .fillMaxHeight(0.8f)
                            .weight(1f),
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            modifier = modifier,
                            text = stringResource(id = test.quest),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.krona_one)),
                                fontWeight = FontWeight(400),
                                color = white
                            )
                        )
                        Spacer(modifier = modifier.height(20.dp))
                        CustomVariantUnswear(
                            title = stringResource(id = test.answer1),
                            isCorrect = selectedAnswer.intValue == test.currentAnswer && selectedAnswer.intValue == test.answer1,
                            isChecked = selectedAnswer.intValue == test.answer1,
                            onClick = {
                                selectedAnswer.intValue = test.answer1
                            }
                        )
                        Spacer(modifier = modifier.height(5.dp))
                        CustomVariantUnswear(
                            title = stringResource(id = test.answer2),
                            isCorrect = selectedAnswer.intValue == test.currentAnswer && selectedAnswer.intValue == test.answer2,
                            isChecked = selectedAnswer.intValue == test.answer2,
                            onClick = {
                                selectedAnswer.intValue = test.answer2
                            }
                        )
                        Spacer(modifier = modifier.height(5.dp))
                        CustomVariantUnswear(
                            title = stringResource(id = test.answer3),
                            isCorrect = selectedAnswer.intValue == test.currentAnswer && selectedAnswer.intValue == test.answer3,
                            isChecked = selectedAnswer.intValue == test.answer3,
                            onClick = {
                                selectedAnswer.intValue = test.answer3
                            }
                        )
                    }
                    Spacer(modifier = modifier.width(10.dp))
                    Column(
                        modifier = modifier
                            .weight(1f)
                            .fillMaxHeight(0.8f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Box(
                            modifier = modifier
                                .clip(shape = RoundedCornerShape(15.dp))
                                .size(screenHeight / 1.7f)
                                .background(brush = brushYellow)
                        ) {
                            Text(
                                modifier = modifier
                                    .align(alignment = Alignment.Center),
                                text = if (selectedAnswer.intValue == -1) "" else if (selectedAnswer.intValue == test.currentAnswer) {
                                    stringResource(
                                        id = R.string.correct
                                    )
                                } else {
                                    stringResource(R.string.wrong)
                                },
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.krona_one)),
                                    fontWeight = FontWeight(400),
                                    textAlign = TextAlign.Center,
                                    color = if (selectedAnswer.intValue == -1) white else if (selectedAnswer.intValue == test.currentAnswer) green else red
                                )
                            )
                        }
                    }
                }
            } else {
                Column(
                    modifier = modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        modifier = modifier,
                        text = stringResource(id = test.quest),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.krona_one)),
                            fontWeight = FontWeight(400),
                            color = white
                        )
                    )
                    Spacer(modifier = modifier.height(20.dp))
                    CustomVariantUnswear(
                        title = stringResource(id = test.answer1),
                        isCorrect = selectedAnswer.intValue == test.currentAnswer && selectedAnswer.intValue == test.answer1,
                        isChecked = selectedAnswer.intValue == test.answer1,
                        onClick = {
                            selectedAnswer.intValue = test.answer1
                        }
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    CustomVariantUnswear(
                        title = stringResource(id = test.answer2),
                        isCorrect = selectedAnswer.intValue == test.currentAnswer && selectedAnswer.intValue == test.answer2,
                        isChecked = selectedAnswer.intValue == test.answer2,
                        onClick = {
                            selectedAnswer.intValue = test.answer2
                        }
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    CustomVariantUnswear(
                        title = stringResource(id = test.answer3),
                        isCorrect = selectedAnswer.intValue == test.currentAnswer && selectedAnswer.intValue == test.answer3,
                        isChecked = selectedAnswer.intValue == test.answer3,
                        onClick = {
                            selectedAnswer.intValue = test.answer3
                        }
                    )
                }
            }
        }
    }
}
