package com.example.rxandroidexample

import android.app.Application
import android.util.Log
import com.example.rxandroidexample.di.AppComponent
import com.example.rxandroidexample.di.DaggerAppComponent
import com.example.rxandroidexample.room.TodoDatabase

class MyApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .setContext(applicationContext)
            .setTodoDatabase(TodoDatabase.getInstance(applicationContext))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("Application", "onCreate")
    }
}