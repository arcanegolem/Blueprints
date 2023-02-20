package com.mockups.blueprints.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.mockups.blueprints.animation.LoadingScreen
import com.mockups.blueprints.animation.MainScreenComposable

@Composable
fun Navigator(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.LoadingScreen.route){
        composable(route = Screen.LoadingScreen.route){
            LoadingScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route){
            MainScreenComposable(navController = navController)
        }
    }
}