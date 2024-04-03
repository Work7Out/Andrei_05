package com.propokeignintion.cardrules.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.propokeignintion.cardrules.R
import com.propokeignintion.cardrules.domain.utils.START_SCREEN
import com.propokeignintion.cardrules.domain.utils.URL
import com.propokeignintion.cardrules.domain.utils.WEB_SCREEN
import com.propokeignintion.cardrules.ui.theme.green
import java.io.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    isInternet:Boolean,
) {
    LaunchedEffect(isInternet) {
        Log.d("test start nav", "isInternet $isInternet")
        delay(3000)
        if (isInternet) {
            navController.navigate(WEB_SCREEN)
        } else {
            navController.navigate(START_SCREEN)
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
        CircularProgressIndicator(
            modifier = modifier
                .align(alignment = Alignment.Center)
                .size(100.dp),
            color = green
        )
    }

}

fun checkAccess(navController: NavHostController) {
    val client = OkHttpClient()
    val request = Request
        .Builder()
        .url(URL)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            navController.navigate(START_SCREEN)
        }

        override fun onResponse(call: Call, response: Response) {
            Log.d("test start nav", "response ${response.code}")
            if (response.code > 400) {
                navController.navigate(START_SCREEN)
            } else {
                navController.navigate(WEB_SCREEN)
            }
        }

    })
}
