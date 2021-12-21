package com.example.rxandroidexample.scene

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.rxandroidexample.R

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
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_add_24),
            contentDescription = ""
        )
        Column() {
            Text(text = title)
            Text(text = "hi")
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    Greeting(title = "Hello?")
}