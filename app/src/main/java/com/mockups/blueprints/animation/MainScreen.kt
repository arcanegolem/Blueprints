package com.mockups.blueprints.animation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mockups.blueprints.blocks.CollapsableBox

@Composable
fun MainScreenComposable(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        CollapsableBox(
            color = MaterialTheme.colorScheme.primary,
            cornerRounding = 5.dp,
            elevation = 4.dp,
            enlargedContent = {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "Icons support additional sizes: 20dp, 40dp, and 48dp, with 20dp primarily for desktop, dense layouts, and small scale visuals, and 40dp and 48dp optimized for display or headline type, plus larger screen sizes.  "
                )
            }) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Hello!"
            )
        }
    }
}
