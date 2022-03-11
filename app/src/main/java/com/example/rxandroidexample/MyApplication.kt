package com.example.rxandroidexample

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext

@HiltAndroidApp
class MyApplication: Application() {
    companion object {
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = this
    }
}