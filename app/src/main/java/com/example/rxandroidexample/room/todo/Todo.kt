package com.example.rxandroidexample.room.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    var title: String,
    var description: String,
    var isChecked: Boolean
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
