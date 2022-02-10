package com.example.rxandroidexample.scene.compose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxandroidexample.scene.compose.data.Word

class WordsNoteActivityViewModel: ViewModel() {
    val word = MutableLiveData(Word("Compose", "구성하다"))
}