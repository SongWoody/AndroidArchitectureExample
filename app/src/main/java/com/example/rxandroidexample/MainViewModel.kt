package com.example.rxandroidexample

import android.content.Intent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.rxandroidexample.room.Todo
import com.example.rxandroidexample.room.TodoDatabase

class MainViewModel(todoDb: TodoDatabase): ViewModel() {

    private val todoList: LiveData<List<Todo>> = todoDb.todoDao().getAllTodoList()
    val todoText: LiveData<String> = Transformations.map(todoList) { totoList ->
        var text = ""
        totoList.map { "id: ${it.id} title: ${it.title} \n" }.forEach {
            text += it
        }
        return@map text
    }

    fun moveRegistrationActivity(v: View) {
        v.context.startActivity(Intent(v.context, RegistrationTodoActivity::class.java))
    }
}