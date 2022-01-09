package com.example.rxandroidexample.scene.start

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import com.example.rxandroidexample.scene.compose.ComposeActivity
import com.example.rxandroidexample.util.SingleLiveEvent

class StartViewModel(
    private val navEvent : SingleLiveEvent<NavDirections>,
    private val startActivityEvent : SingleLiveEvent<Class<out Activity>>
) : ViewModel() {

    class Factory constructor(
        private val navEvent : SingleLiveEvent<NavDirections>,
        private val startActivityEvent : SingleLiveEvent<Class<out Activity>>
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(StartViewModel::class.java)) {
                return StartViewModel(navEvent, startActivityEvent) as T
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

    fun moveComposeActivity() {
        startActivityEvent.value = ComposeActivity::class.java
    }
}