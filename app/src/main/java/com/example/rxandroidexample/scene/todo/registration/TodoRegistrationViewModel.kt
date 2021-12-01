package com.example.rxandroidexample.scene.todo.registration

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rxandroidexample.room.Todo
import com.example.rxandroidexample.room.TodoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoRegistrationViewModel @ViewModelInject constructor(
    private val todoDb: TodoDatabase
): ViewModel() {

    class Factory constructor(
        private val todoDb: TodoDatabase
    ): ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TodoRegistrationViewModel::class.java)) {
                return TodoRegistrationViewModel(todoDb) as T
            }
            throw IllegalArgumentException("Factory cannot make ViewModel of type ${modelClass.simpleName}")
        }
    }

    val title = MutableLiveData("")
    val description = MutableLiveData("")

    fun addTodo(title: String?, description: String?) {
        if (title != null && description != null) {
            CoroutineScope(Dispatchers.IO).launch {
                todoDb.todoDao().insert(Todo(title, description, false))
            }
        }
    }
}