package com.mockups.blueprints.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mockups.blueprints.R
import coil.compose.AsyncImage
import com.mockups.blueprints.navigation.Screen

@Composable
fun LoadingScreen(navController: NavController) {
    var animated by remember { mutableStateOf(true) }
    val rotY = remember { androidx.compose.animation.core.Animatable(initialValue = 360f) }
    val rotX = remember { androidx.compose.animation.core.Animatable(initialValue = 360f) }

    val animCount = 6f
    var counter by remember { mutableStateOf(0f) }

    var visible by remember { mutableStateOf(true) }

    LaunchedEffect(animated){
        while (counter != animCount){
            rotY.animateTo(
                targetValue = if (animated) 0f else 360f,
                animationSpec = tween(durationMillis = 800)
            )

            counter ++
            if (counter == animCount - 1){
                visible = false
            }

            rotX.animateTo(
                targetValue = if (animated) 0f else 360f,
                animationSpec = tween(durationMillis = 800)
            )

            counter ++
            animated = !animated
        }
        navController.navigate(Screen.MainScreen.route)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .graphicsLayer {
                        rotationY = rotY.value
                        rotationX = rotX.value
                    }
                    .padding(20.dp),
                model = R.mipmap.blueprint_moment,
                contentDescription = null
        )
        LinearProgressIndicator()
    }
}