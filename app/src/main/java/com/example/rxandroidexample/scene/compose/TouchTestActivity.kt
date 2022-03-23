package com.example.rxandroidexample.scene.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rxandroidexample.scene.compose.ui.theme.RxAndroidExampleTheme

class TouchTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RxAndroidExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@Composable
fun Greeting2() {
    val count = remember {
        mutableStateOf(0)
    }
    Column() {
        Text(text = "Hello ${count.value}!",
            modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        Log.i("TouchTest", "onPress")
                    },
                    onDoubleTap = {
                        Log.i("TouchTest", "onDoubleTap")
                    },
                    onLongPress = {
                        Log.i("TouchTest", "onLongPress")
                    },
                    onTap = {
                        Log.i("TouchTest", "onTap")
                    }
                )
            })
        Column(
            modifier = Modifier
                .background(Color.Gray)
                .size(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            repeat(20) {
                Text(text = "Item $it", modifier = Modifier.padding(3.dp))
            }
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    RxAndroidExampleTheme {
        Greeting2()
    }
}