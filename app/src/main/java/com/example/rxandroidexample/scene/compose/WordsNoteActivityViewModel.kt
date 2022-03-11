package com.example.rxandroidexample.scene.compose

import androidx.lifecycle.ViewModel
import com.example.rxandroidexample.MyApplication
import com.example.rxandroidexample.room.word.WordDatabase

class WordsNoteActivityViewModel: ViewModel() {
    val wordsLive = WordDatabase.getInstance(MyApplication.context).wordDao().getAllTodoList()
}