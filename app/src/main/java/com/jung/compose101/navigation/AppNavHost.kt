package com.jung.compose101.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jung.compose101.screen.main.MainScreen
import com.jung.compose101.screen.week1.Week1
import com.jung.compose101.screen.week3.Week3ViewModel
import com.jung.compose101.screen.week3.Week3v2
import com.jung.compose101.screen.week4.stabledemo.FriendScreen
import com.jung.compose101.screen.week4.stabledemo.FriendsViewModel

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.route,
    ) {
        composable(MainScreen.route) {
            MainScreen(
                navigate = { destination ->
                    when (destination.route) {
                        WeekRoute.Week1Screen.route ->
                            navController.navigate(WeekRoute.Week1Screen.route)

                        WeekRoute.Week3Screen.route ->
                            navController.navigate(WeekRoute.Week3Screen.route)

                        WeekRoute.Week4Screen.route ->
                            navController.navigate(WeekRoute.Week4Screen.route)
                    }
                },
            )
        }

        composable(WeekRoute.Week1Screen.route) {
            Week1(navBack = { navController.navigateUp() })
        }

        composable(WeekRoute.Week3Screen.route) {
            val viewModel: Week3ViewModel = viewModel()
            val uiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()

            Week3v2(
                uiState = uiState,
                uiEvent = viewModel::handleEvent,
            )
        }

        composable(WeekRoute.Week4Screen.route) {
            val viewModel: FriendsViewModel = viewModel()
            val uiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()

            FriendScreen(
                uiState = uiState,
                uiEvent = viewModel::handleEvent,
            )
        }
    }
}