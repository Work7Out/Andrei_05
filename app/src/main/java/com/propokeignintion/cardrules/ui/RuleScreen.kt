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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.propokeignintion.cardrules.data.mock_data.rules
import com.propokeignintion.cardrules.domain.utils.RULE_SCREEN
import com.propokeignintion.cardrules.domain.utils.TEST_SCREEN
import com.propokeignintion.cardrules.ui.theme.black
import com.propokeignintion.cardrules.ui.theme.brushYellow
import com.propokeignintion.cardrules.ui.theme.white
import com.propokeignintion.cardrules.ui.uikit.CustomButton20dp
import com.propokeignintion.cardrules.ui.uikit.CustomButtonImageText
import com.propokeignintion.cardrules.ui.uikit.CustomButtonTextImage20dp

@Composable
fun RuleScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    indexRule: Int,
    isSound: Boolean,
    mediaPlayer: MediaPlayer,
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val rule = rules.first { it.id == indexRule }

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
                            text = "${stringResource(id = R.string.rule)} #$indexRule",
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
                            text = "${stringResource(id = R.string.rule)} #$indexRule",
                            style = TextStyle(
                                fontSize = 20.sp,
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
                    CustomButtonTextImage20dp(
                        modifier = modifier.padding(16.dp),
                        title = stringResource(id = R.string.pass_test),
                        image = R.drawable.baseline_arrow_right_alt_24,
                        onClick = {
                            navController.navigate("$TEST_SCREEN/${rule.id}")
                        }
                    )
                }
            }
        ) {innerPadding ->
            if (isLandscape) {
                Row(
                    modifier = modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.Top,
                ) {
                    Column(
                        modifier = modifier.weight(1f)
                    ) {
                        CustomButtonImageText(
                            title = stringResource(id = rule.title),
                            image = rule.icon,
                            onClick = {}
                        )
                        Spacer(modifier = Modifier.height(7.dp))
                        Image(
                            modifier = Modifier.fillMaxWidth(),
                            painter =  painterResource( id = rule.image),
                            contentDescription = "",
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Spacer(modifier = modifier.width(10.dp))
                    Column(
                        modifier = modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = modifier
                                .clip(shape = RoundedCornerShape(15.dp))
                                .fillMaxWidth()
                                .background(brush = brushYellow)
                                .padding(20.dp)
                                .verticalScroll(rememberScrollState()),
                        ) {
                            Text(
                                modifier = modifier,
                                text = stringResource(id = rule.content),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    color = black
                                )
                            )
                        }
                        CustomButtonTextImage20dp(
                            modifier = modifier,
                            title = stringResource(id = R.string.pass_test),
                            image = R.drawable.baseline_arrow_right_alt_24,
                            onClick = {
                                navController.navigate("$TEST_SCREEN/${rule.id}")
                            }
                        )
                    }
                }
            } else {
                Column(
                    modifier = modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    CustomButtonImageText(
                        title = stringResource(id = rule.title),
                        image = rule.icon,
                        onClick = {}
                    )
                    Spacer(modifier = modifier.height(7.dp))
                    Image(
                        modifier = modifier.fillMaxWidth(),
                        painter =  painterResource( id = rule.image),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Column(
                        modifier = modifier
                            .padding(vertical = 16.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .fillMaxWidth()
                            .background(brush = brushYellow)
                            .padding(20.dp)
                            .verticalScroll(rememberScrollState()),
                    ) {
                        Text(
                            modifier = modifier,
                            text = stringResource(id = rule.content),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = black
                            )
                        )
                    }
                }
            }
        }
    }
}
