package com.example.rxandroidexample.scene.compose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxandroidexample.scene.compose.data.Word

class WordsNoteActivityViewModel: ViewModel() {
    //todo: 디비로 데이터 관리
    val words = MutableLiveData(listOf(
        Word("Compose", "구성하다"),
        Word("Dentist", "치과 의사")
    ))
}