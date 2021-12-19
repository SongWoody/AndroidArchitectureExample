package com.example.rxandroidexample.scene

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

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
    Text(text = title)
}