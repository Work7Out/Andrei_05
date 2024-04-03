package com.propokeignintion.cardrules.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.propokeignintion.cardrules.ui.navigation.NavController
import com.propokeignintion.cardrules.ui.theme.Andrei_05Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            val systemUIController = rememberSystemUiController()
            systemUIController.isNavigationBarVisible = false
            systemUIController.isStatusBarVisible = false
            Andrei_05Theme {
                NavController()
            }
        }
    }
}