package com.mockups.blueprints.navigation

sealed class Screen (val route: String) {
    object MainScreen : Screen(route = "main_screen")
    object LoadingScreen : Screen(route = "loading_screen")
}