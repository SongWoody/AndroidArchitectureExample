package com.example.rxandroidexample.scene.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ComposeDrawer(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Column {
        Box(
            Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(1.0f)
                .wrapContentHeight()
        ) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = {
                scope.launch {
                    drawerState.close()
                }
            }) {
                Icon(
                    modifier = Modifier.size(40.dp).padding(8.dp),
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close Button",
                    tint = Color.Black
                )
            }
        }
    }
}