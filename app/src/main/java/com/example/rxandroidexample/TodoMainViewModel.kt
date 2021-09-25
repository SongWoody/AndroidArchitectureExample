package com.example.rxandroidexample

import android.content.Intent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rxandroidexample.room.Todo
import com.example.rxandroidexample.room.TodoDatabase

class TodoMainViewModel(todoDb: TodoDatabase) : ViewModel() {

    class Factory constructor(
        private val todoDb: TodoDatabase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TodoMainViewModel::class.java)) {
                return TodoMainViewModel(todoDb) as T
            }
            throw IllegalArgumentException("Factory cannot make ViewModel of type ${modelClass.simpleName}")
        }
    }

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