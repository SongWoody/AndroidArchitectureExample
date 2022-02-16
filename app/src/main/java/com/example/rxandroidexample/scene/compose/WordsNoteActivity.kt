package com.example.rxandroidexample.scene.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rxandroidexample.scene.compose.data.Word
import com.example.rxandroidexample.scene.compose.ui.theme.RxAndroidExampleTheme

class WordsNoteActivity : ComponentActivity() {
    private val viewModel: WordsNoteActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RxAndroidExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: WordsNoteActivityViewModel) {
    val word = viewModel.word.observeAsState()
    Column() {
        Text(text = "Word: ${word.value?.word}!")
        Text(text = "Mean: ${word.value?.mean}!")

        Button(onClick = {
            viewModel.word.value = Word("Exercise","운동하다")
        }) {
            Text(text = "Test Button")
        }
    }

    LazyColumn {
        items(5) {
            Text(text = "Item $this")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RxAndroidExampleTheme {
//        Greeting(view)
    }
}

@Composable
//todo card item 받아서 ui 노출
fun WordCard() {
    Card() {

    }
}