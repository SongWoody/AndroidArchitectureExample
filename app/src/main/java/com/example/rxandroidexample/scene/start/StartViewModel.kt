package com.example.rxandroidexample.scene.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import com.example.rxandroidexample.util.SingleLiveEvent

class StartViewModel(
    private val navEvent : SingleLiveEvent<NavDirections>
) : ViewModel() {

    class Factory constructor(
        private val navEvent : SingleLiveEvent<NavDirections>
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(StartViewModel::class.java)) {
                return StartViewModel(navEvent) as T
            }
            throw IllegalArgumentException("Factory cannot make ViewModel of type ${modelClass.simpleName}")
        }
    }

    fun moveSecondFragment() {
        navEvent.postValue(StartFragmentDirections.actionMainFragmentToSecondFragment())
    }

    fun moveTodoListFragment() {
        navEvent.postValue(StartFragmentDirections.actionMainFragmentToTodoListFragment())
    }
}