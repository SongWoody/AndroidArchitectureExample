package com.example.rxandroidexample.scene.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rxandroidexample.scene.compose.data.Word
import com.example.rxandroidexample.scene.compose.ui.theme.RxAndroidExampleTheme
import com.example.rxandroidexample.scene.compose.view.WordCard

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
    val words = viewModel.words.observeAsState()
    LazyColumn(
        Modifier.padding(top = 12.dp)
    ) {
        items(words.value ?: listOf()) { item: Word ->
            WordCard(word = item)
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