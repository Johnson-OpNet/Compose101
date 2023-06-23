package com.jung.compose101.navigation

interface Route {
    val route: String
}

object MainScreen : Route {
    override val route: String = "main_screen_route"
}

sealed interface WeekRoute : Route {
    object Week1Screen : WeekRoute {
        override val route: String = "week_1_route"
    }

    object Week3Screen : WeekRoute {
        override val route: String = "week_3_route"
    }

    object Week4Screen : WeekRoute {
        override val route: String = "week_4_route"
    }
}