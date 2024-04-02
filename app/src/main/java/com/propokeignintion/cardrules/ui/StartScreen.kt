package com.propokeignintion.cardrules.ui

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.propokeignintion.cardrules.R
import com.propokeignintion.cardrules.domain.utils.INFO_SCREEN
import com.propokeignintion.cardrules.domain.utils.LIST_RULE_SCREEN
import com.propokeignintion.cardrules.domain.utils.LIST_TESTS_SCREEN
import com.propokeignintion.cardrules.ui.state.MainEvent
import com.propokeignintion.cardrules.ui.uikit.CustomButton20dp

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    isSound: Boolean,
    mediaPlayer: MediaPlayer,
    event: (MainEvent) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = modifier
                .align(alignment = Alignment.TopCenter)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = {
                if (isSound) {
                    mediaPlayer.start()
                }
                event(MainEvent.SetSound)
            }) {
                Image(
                    painter = if (isSound) painterResource(id = R.drawable.media_on) else painterResource(
                        id = R.drawable.media_off
                    ),
                    contentDescription = ""
                )
            }
            TextButton(onClick = {
                if (isSound) {
                    mediaPlayer.start()
                }
                navController.navigate(INFO_SCREEN)
            }) {
                Image(
                    painter =  painterResource( id = R.drawable.info_bt),
                    contentDescription = ""
                )
            }
        }
        Column (
            modifier = modifier
                .align(alignment = Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CustomButton20dp(
                title = stringResource(id = R.string.list_of_rules),
                onClick = {
                    if (isSound) {
                        mediaPlayer.start()
                    }
                    navController.navigate(LIST_RULE_SCREEN)
                }
            )
            Spacer(modifier = modifier.height(10.dp))
            CustomButton20dp(
                title = stringResource(id = R.string.list_of_tests),
                onClick = {
                    if (isSound) {
                        mediaPlayer.start()
                    }
                    navController.navigate(LIST_TESTS_SCREEN)
                }
            )
        }
    }
}
