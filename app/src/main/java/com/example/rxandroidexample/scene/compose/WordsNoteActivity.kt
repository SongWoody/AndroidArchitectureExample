package com.example.rxandroidexample.scene.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.example.rxandroidexample.room.word.Word
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rxandroidexample.scene.compose.ui.theme.RxAndroidExampleTheme
import com.example.rxandroidexample.scene.compose.view.WordCard
import kotlinx.coroutines.*

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
    Log.i("","Greeting")
    val wordsLive: State<List<Word>?> = viewModel.wordsLive.observeAsState()
    Column {
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        Log.i("pointerInput", "$change, $dragAmount")
                    }
                    detectDragGesturesAfterLongPress(
                        onDrag = { change, dragAmount ->
                            Log.i("detectDragGesturesAfterLongPress", "$change, $dragAmount")
                        }
                    )
                },
            onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.db.wordDao().insert(Word("Apple","사과"))
            }
        }) {
            Text(text = "Test")
        }
        LazyColumn(
            Modifier.padding(top = 14.dp)
        ) {
            items(items = wordsLive.value ?: listOf()) {  item: Word ->
                WordCard(word = item)
            }
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