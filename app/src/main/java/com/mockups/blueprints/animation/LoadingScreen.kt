package com.mockups.blueprints.animation

import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.mockups.blueprints.R
import coil.compose.AsyncImage

@Composable
fun LoadingScreen(){
    var animated by remember { mutableStateOf(true) }
    val rotY = remember { androidx.compose.animation.core.Animatable(initialValue = 360f) }
    val rotX = remember { androidx.compose.animation.core.Animatable(initialValue = 360f) }

    LaunchedEffect(animated){
        rotY.animateTo(
            targetValue = if (animated) 0f else 360f,
            animationSpec = tween(durationMillis = 1200)
        )
        rotX.animateTo(
            targetValue = if (animated) 0f else 360f,
            animationSpec = tween(durationMillis = 1200)
        )
        animated = !animated
    }

    AsyncImage(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .graphicsLayer {
            rotationY = rotY.value
            rotationX = rotX.value
        },
        model = R.mipmap.blueprint_moment,
        contentDescription = null
    )
}