package com.example.rxandroidexample

import android.app.Application
import android.util.Log
import com.example.rxandroidexample.di.AppComponent
import com.example.rxandroidexample.di.DaggerAppComponent
import com.example.rxandroidexample.di.AppModule

class MyApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("Application", "onCreate")
    }
}