package com.example.rxandroidexample.scene

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
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

class ComposeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MessageList(listOf(
                    Message("Welcome", "Hello Compose World"),
                    Message("Welcome2", "Hello Compose World2"),
                    Message("Welcome3", "Hello Compose World3"),
                    Message("Welcome4", "Hello Compose World4")
                ))
            }
        }
    }
}

@Composable
private fun MessageList(messages: List<Message>) {
    LazyColumn{
        items(messages) { msg ->
            MessageCard(msg = msg)
        }
    }
}

@Composable
private fun MessageCard(msg: Message) {
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
        Column {
            Text(
                text = msg.title,
                color = MaterialTheme.colors.secondaryVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = msg.body
            )
        }
    }
}

@Preview(name = "Light Theme")
@Preview(name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewMessageCard() {
    MaterialTheme {
        MessageList(listOf(
            Message("Preview1","Preview Body1"),
            Message("Preview2","Preview Body2"),
            Message("Preview3","Preview Body3"),
            Message("Preview4","Preview Body4"),
            Message("Preview5","Preview Body5"),
            Message("Preview6","Preview Body6"),
            Message("Preview7","Preview Body7")
        ))
    }
}