package com.example.rxandroidexample.scene

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                    Message("Welcome", "Hello Compose World\nHI"),
                    Message("Welcome2", "Hello Compose World2\nHello Compose World2\nHello Compose World2"),
                    Message("Welcome3", "Hello Compose World3\nHI"),
                    Message("Welcome4", "Hello Compose World4\nHI")
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
        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor: Color by animateColorAsState(
            targetValue = if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )
        Column(modifier = Modifier.clickable {
            isExpanded = !isExpanded
        }) {
            Text(
                text = msg.title,
                color = MaterialTheme.colors.secondaryVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview(name = "Light Theme")
@Preview(name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewMessageCard() {
    MaterialTheme {
        MessageList(listOf(
            Message("Preview1","Preview Body1 Logn Body mmmmmmmmmmsssssssssggggggg"),
            Message("Preview2","Preview Body2"),
            Message("Preview3","Preview Body3"),
            Message("Preview4","Preview Body4"),
            Message("Preview5","Preview Body5"),
            Message("Preview6","Preview Body6"),
            Message("Preview7","Preview Body7")
        ))
    }
}