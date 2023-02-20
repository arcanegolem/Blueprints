package com.mockups.blueprints

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mockups.blueprints.blocks.CollapsableBox
import com.mockups.blueprints.ui.theme.BlueprintsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlueprintsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        TestingCmp()
                    }
                }
            }
        }
    }
}

@Composable
fun TestingCmp() {
    /*ColoredBlock(
        color = MaterialTheme.colorScheme.primary,
        backgroundColor = MaterialTheme.colorScheme.secondary,
        colorPadding = 5.dp,
        shape = RoundedCornerShape(5.dp),
        elevation = 4.dp
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Hello!"
        )
    }*/


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
