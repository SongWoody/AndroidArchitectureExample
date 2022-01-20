package com.example.rxandroidexample.scene.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rxandroidexample.util.printLog

class ComposeLifeCycleTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            printLog("create LifecycleTestView")
            LifecycleTestView()
        }
    }
}

@Preview
@Composable
fun PreviewLifecycleTestView() {
    LifecycleTestView()
}

@Composable
fun LifecycleTestView() {
    val rememberCount = remember {
        mutableStateOf(0)
    }
    printLog("create Scaffold")
    Scaffold {
        printLog("create Column")
        Column(
            modifier = Modifier
                .background(Color(0x88848400))
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
        ) {
            printLog("create Button 1")
            Button(
                modifier = Modifier
                    .background(Color(0x2200ff00))
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp, bottom = 10.dp),
                onClick = {
                    rememberCount.value++
                }
            ) {
                printLog("create Text 1")
                Text(text = "count = ${rememberCount.value}")
            }


            val rememberCount2 = remember {
                mutableStateOf(9999)
            }
            printLog("create Button 2")
            Button(
                modifier = Modifier
                    .background(Color(0x2200ff00))
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp, bottom = 10.dp),
                onClick = {
                    rememberCount2.value--
                }
            ) {
                printLog("create Text 2")
                Text(text = "count = ${rememberCount2.value}")
            }
        }
    }
}