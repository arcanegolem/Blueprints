package com.mockups.blueprints.blocks

import com.mockups.blueprints.R
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CollapsibleBox(
    modifier: Modifier = Modifier,
    color: Color,
    shape: RoundedCornerShape,
    elevation: Dp,
    content2: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = elevation, shape = shape)
            .clip(shape),
        color = color
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 10.dp, bottom = 10.dp, end = 10.dp)
                    .clickable(
                        onClick = {
                            isExpanded = !isExpanded
                        }
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                content()
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
                content2()
            }
        }
    }
}
