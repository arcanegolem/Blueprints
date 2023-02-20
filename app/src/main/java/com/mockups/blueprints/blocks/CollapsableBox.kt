package com.mockups.blueprints.blocks

import com.mockups.blueprints.R
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CollapsableBox(
    modifier: Modifier = Modifier,
    color: Color,
    cornerRounding: Dp = 5.dp,
    elevation: Dp = 0.dp,
    enlargedContent: @Composable () -> Unit,
    collapsedContent: @Composable () -> Unit
) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    val dpShape by animateDpAsState(targetValue = if (isExpanded) cornerRounding else cornerRounding * 4)

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = elevation, shape = RoundedCornerShape(dpShape))
            .clip(RoundedCornerShape(dpShape)),
        color = color
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 10.dp, bottom = 10.dp, end = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable(
                        onClick = {
                            isExpanded = !isExpanded
                        }
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                collapsedContent()
                Icon(
                    painter = painterResource(
                        id = if (isExpanded) {
                            R.drawable.round_expand_less_24
                        } else {
                            R.drawable.round_expand_more_24
                        }
                    ),
                    contentDescription = null
                )
            }
            AnimatedVisibility(visible = isExpanded) {
                enlargedContent()
            }
        }
    }
}
