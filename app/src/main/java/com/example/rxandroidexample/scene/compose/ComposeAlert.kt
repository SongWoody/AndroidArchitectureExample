package com.example.rxandroidexample.scene.compose

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun ComposeAlert(
    openDialog: MutableState<Boolean>,
    title: String,
    message: String,
    onConfirmButtonClick: () -> Unit
) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(title)
            },
            text = {
                Text(message)
            },
            confirmButton = {
                Button(
                    onClick = onConfirmButtonClick
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}