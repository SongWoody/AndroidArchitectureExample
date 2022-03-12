package com.example.rxandroidexample.scene.compose

import androidx.lifecycle.ViewModel
import com.example.rxandroidexample.MyApplication
import com.example.rxandroidexample.room.word.WordDatabase

class WordsNoteActivityViewModel: ViewModel() {
    val db = WordDatabase.getInstance(MyApplication.context)
    val wordsLive = db.wordDao().getAllTodoList()
}