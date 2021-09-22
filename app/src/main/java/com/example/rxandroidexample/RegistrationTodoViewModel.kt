package com.example.rxandroidexample

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxandroidexample.room.Todo
import com.example.rxandroidexample.room.TodoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationTodoViewModel(private val todoDb: TodoDatabase): ViewModel(){
    val title = MutableLiveData("")
    val description = MutableLiveData("")

    fun addTodo() {
        val title = title.value
        val description = description.value
        if (title != null && description != null) {
            CoroutineScope(Dispatchers.IO).launch {
                todoDb.todoDao().insert(Todo(title, description))
            }
        }
    }
}