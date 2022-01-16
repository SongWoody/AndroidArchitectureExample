package com.example.rxandroidexample.scene.compose

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class ComposeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ComposeView() }
    }
}

@Preview(name = "Light Theme")
@Preview(name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewComposeActivity() {
    ComposeView()
}

@Composable
private fun ComposeView() {
    val context = LocalContext.current
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState)
    val scope = rememberCoroutineScope()
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("TopBar") }, backgroundColor = Color(0xFF1976D2))
            },
            scaffoldState = scaffoldState,
            drawerContent = {
                ComposeDrawer(drawerState = drawerState)
            }
        ) {
            Column {
                Button(onClick = {
                    scope.launch {
                        if (drawerState.isClosed) drawerState.open() else drawerState.close()
                    }                }) {
                    Text("Drawer Button")
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    Button(
                        modifier = Modifier.align(Alignment.Center),
                        onClick = {
                            context.startActivity(
                                Intent(
                                    context,
                                    ComposeActivity2::class.java
                                )
                            )
                        }) {
                        Text(text = "Next Page")
                    }
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)){
                    val alertRemember = remember { mutableStateOf(false) }
                    Button(
                        modifier = Modifier.align(Alignment.Center),
                        onClick = {
                            alertRemember.value = true
                        }
                    ) {
                        Text(text = "Show Alter")
                    }
                }
            }
        }
    }
}