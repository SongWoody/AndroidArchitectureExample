package com.example.rxandroidexample.scene.compose.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rxandroidexample.room.word.Word

@Composable
fun WordCard(
    word: Word
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        elevation = 7.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 5.dp)
        ) {
            Text(
                word.word,
                modifier = Modifier.padding(start = 12.dp, top = 8.dp),
                color = Color(0xff2f2f2f)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                word.mean,
                modifier = Modifier.padding(start = 12.dp, bottom = 8.dp),
                color = Color(0xff2f2f2f)
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