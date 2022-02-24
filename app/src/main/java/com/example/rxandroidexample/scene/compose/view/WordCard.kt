package com.example.rxandroidexample.scene.compose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rxandroidexample.scene.compose.data.Word

@Composable
fun WordCard(
    word: Word
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        Column() {
            Text(
                word.word,
                modifier = Modifier.padding(start = 12.dp, top = 8.dp)
            )
            Text(
                word.mean,
                modifier = Modifier.padding(start = 12.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        WordCard(word = Word("Test","테스트"))
        WordCard(word = Word("Test1","테스트1"))
        WordCard(word = Word("Test2","테스트2"))
    }
}