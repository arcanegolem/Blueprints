package com.mockups.blueprints

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.mockups.blueprints.blocks.ColoredBlock
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
    ColoredBlock(
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
    }
}
