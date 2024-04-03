package com.propokeignintion.cardrules.ui.navigation

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.propokeignintion.cardrules.R
import com.propokeignintion.cardrules.domain.utils.LOADING_SCREEN
import com.propokeignintion.cardrules.domain.utils.START_SCREEN
import com.propokeignintion.cardrules.domain.utils.WEB_SCREEN
import com.propokeignintion.cardrules.ui.InfoScreen
import com.propokeignintion.cardrules.ui.ListRulesScreen
import com.propokeignintion.cardrules.ui.ListTestsScreen
import com.propokeignintion.cardrules.ui.LoadingScreen
import com.propokeignintion.cardrules.ui.Rule4Screen
import com.propokeignintion.cardrules.ui.RuleScreen
import com.propokeignintion.cardrules.ui.StartScreen
import com.propokeignintion.cardrules.ui.TestScreen
import com.propokeignintion.cardrules.ui.WebViewScreen
import com.propokeignintion.cardrules.ui.state.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun NavController(
    startDestination: String = LOADING_SCREEN,
    viewModel: MainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    val state = viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent
    val context = LocalContext.current
    val mediaPlayer = MediaPlayer.create(context, R.raw.zvuk)

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
        }
    }
    /**/


    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationDestination.StartDestination.destination) {
            StartScreen(
                mediaPlayer = mediaPlayer,
                navController = navController,
                isSound = state.value.isSoundOn,
                event = onEvent
            )
        }
        composable(NavigationDestination.InfoDestination.destination) {
            InfoScreen(
                navController = navController,
                isSound = state.value.isSoundOn,
                mediaPlayer = mediaPlayer
            )
        }
        composable(NavigationDestination.WebDestination.destination) {
            WebViewScreen(navController = navController)
        }
        composable(NavigationDestination.LoadingDestination.destination) {
           LoadingScreen(
               navController = navController,
               isInternet = state.value.isInternet)
        }

        composable(
            NavigationDestination.ListTestsDestination.destination,
        ) {
            ListTestsScreen(
                navController = navController,
                isSound = state.value.isSoundOn,
                mediaPlayer = mediaPlayer
            )
        }

        composable(
            NavigationDestination.ListRulesDestination.destination,
        ) {
            ListRulesScreen(
                navController = navController,
                isSound = state.value.isSoundOn,
                mediaPlayer = mediaPlayer
            )
        }
        composable(
            NavigationDestination.TestDestination.destination,
            arguments = listOf(navArgument("idTest") {
                type = NavType.IntType
            }
            )
        ) {
            val indexTest = it.arguments?.getInt("idTest")
            if (indexTest != null) {
                TestScreen(
                    indexTest = indexTest,
                    navController = navController,
                    isSound = state.value.isSoundOn,
                    mediaPlayer = mediaPlayer
                )
            }
        }
        composable(
            NavigationDestination.Rule4Destination.destination,
            arguments = listOf(navArgument("idRule") {
                type = NavType.IntType
            })
        ) {
            val indexRule = it.arguments?.getInt("idRule")
            if (indexRule != null) {
                Rule4Screen(
                    indexRule = indexRule,
                    navController = navController,
                    isSound = state.value.isSoundOn,
                    mediaPlayer = mediaPlayer
                )
            }
        }
        composable(
            NavigationDestination.RuleDestination.destination,
            arguments = listOf(navArgument("idRule") {
                type = NavType.IntType
            })
        ) {
            val indexRule = it.arguments?.getInt("idRule")
            if (indexRule != null) {
                RuleScreen(
                    indexRule = indexRule,
                    navController = navController,
                    isSound = state.value.isSoundOn,
                    mediaPlayer = mediaPlayer
                )
            }
        }
    }
}