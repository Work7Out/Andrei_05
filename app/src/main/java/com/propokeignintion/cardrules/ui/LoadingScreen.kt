package com.propokeignintion.cardrules.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.propokeignintion.cardrules.R
import com.propokeignintion.cardrules.domain.utils.START_SCREEN
import com.propokeignintion.cardrules.domain.utils.WEB_SCREEN
import com.propokeignintion.cardrules.ui.theme.green
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    isInternet:Boolean,
) {
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
        CircularProgressIndicator(
            modifier = modifier
                .align(alignment = Alignment.Center)
                .size(100.dp),
            color = green
        )
    }
}
