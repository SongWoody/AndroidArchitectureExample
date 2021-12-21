package com.example.rxandroidexample.scene

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ComposeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Hello Compose World")
        }
    }
}

@Composable
private fun Greeting(title: String) {
    Column() {
        Text(text = title)
        Text(text = "hi")
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    Greeting(title = "Hello?")
}