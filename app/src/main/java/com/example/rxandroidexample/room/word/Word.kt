package com.example.rxandroidexample.room.word

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
    var word: String,
    var mean: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
