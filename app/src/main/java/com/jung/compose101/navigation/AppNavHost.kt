package com.jung.compose101.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jung.compose101.screen.main.MainScreen
import com.jung.compose101.screen.week1.Week1

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
                    }
                },
            )
        }

        composable(WeekRoute.Week1Screen.route) {
            Week1(navBack = { navController.navigateUp() })
        }
    }
}