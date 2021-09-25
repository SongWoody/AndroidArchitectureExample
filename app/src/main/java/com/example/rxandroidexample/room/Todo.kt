package com.example.rxandroidexample.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    val title: String,
    val description: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}