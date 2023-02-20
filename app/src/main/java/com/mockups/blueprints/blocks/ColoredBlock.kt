package com.mockups.blueprints.blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun ColoredBlock(
    modifier: Modifier = Modifier,
    color: Color,
    backgroundColor: Color,
    colorPadding : Dp,
    shape : RoundedCornerShape,
    elevation : Dp,
    content: @Composable () -> Unit
){
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = elevation, shape = shape)
            .clip(shape),
        color = color
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = colorPadding)
            .background(color = backgroundColor)
        ) {
            content()
        }
    }
}