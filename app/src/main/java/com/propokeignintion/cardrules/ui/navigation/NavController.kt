package com.propokeignintion.cardrules.ui.navigation

import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.propokeignintion.cardrules.R
import com.propokeignintion.cardrules.domain.utils.START_SCREEN
import com.propokeignintion.cardrules.ui.InfoScreen
import com.propokeignintion.cardrules.ui.ListRulesScreen
import com.propokeignintion.cardrules.ui.StartScreen
import com.propokeignintion.cardrules.ui.state.MainViewModel

@Composable
fun NavController(
    startDestination: String = START_SCREEN,
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
                mediaPlayer = mediaPlayer)
        }
        composable(
            NavigationDestination.ListTestsDestination.destination,
        ) {

        }

        composable(
            NavigationDestination.ListRulesDestination.destination,
            ) {
            ListRulesScreen(
                navController = navController,
                isSound = state.value.isSoundOn,
                mediaPlayer = mediaPlayer)
        }
        composable(
            NavigationDestination.TestDestination.destination,
            arguments = listOf(navArgument("idTest") {
                type = NavType.IntType
            }
            )
        ) {

        }
        composable(
            NavigationDestination.RuleDestination.destination,
            arguments = listOf(navArgument("idRule") {
                type = NavType.IntType
            })
        ) {

        }
    }
}