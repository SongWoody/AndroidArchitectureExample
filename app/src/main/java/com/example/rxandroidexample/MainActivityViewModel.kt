package com.example.rxandroidexample

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel(), LifecycleObserver {

    private val TAG: String = "MainActivityViewModel"

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Log.i(TAG, "start: Hello")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        Log.i(TAG, "stop: Bye Bye")
    }

    fun print() {
        Log.i(TAG, "print: ")
    }
}