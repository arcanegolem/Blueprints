package com.mockups.blueprints.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.mockups.blueprints.animation.LoadingScreen
import com.mockups.blueprints.animation.MainScreenComposable
import com.mockups.blueprints.blocks.CollapsableBox

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