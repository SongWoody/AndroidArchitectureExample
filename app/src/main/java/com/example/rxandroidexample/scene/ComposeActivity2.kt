package com.example.rxandroidexample.scene

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*

class ComposeActivity2: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ComposeView()
            }
        }
    }
}

@Composable
private fun ComposeView() {
    Text(text = "Hi ComposeActivity2")
}