package com.example.rxandroidexample

import android.app.Application
import android.util.Log
import com.example.rxandroidexample.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        Log.i("Application", "onCreate")
        DaggerAppComponent.factory().create(this).inject(this)
    }

    override fun androidInjector() = dispatchingAndroidInjector
}