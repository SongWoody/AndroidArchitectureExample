package com.example.rxandroidexample.scene.todo.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import com.example.rxandroidexample.room.TodoDatabase
import com.example.rxandroidexample.util.SingleLiveEvent

class TodoMainViewModel(val todoDb: TodoDatabase) : ViewModel() {

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

    val navEvent = SingleLiveEvent<NavDirections>()

    val todoList = todoDb.todoDao().getAllTodoList()

    fun moveRegistrationActivity() {
        navEvent.value = TodoListFragmentDirections.actionTodoListFragmentToTodoRegistrationFragment()
    }
}