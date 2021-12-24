package com.example.rxandroidexample.scene

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rxandroidexample.R
import com.example.rxandroidexample.data.Message

class ComposeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(Message("Welcome", "Hello Compose World"))
        }
    }
}

@Composable
private fun Greeting(msg: Message) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Box {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.mipmap.ic_test),
                contentDescription = ""
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(text = msg.title)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    Greeting(Message("Preview","Preview Body"))
}