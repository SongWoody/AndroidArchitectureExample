package com.example.rxandroidexample.scene.main

import android.util.Log
import com.example.rxandroidexample.di.scope.ActivityScope
import com.example.rxandroidexample.scene.main.fragment.MainFragmentComponent
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(subcomponents = [MainFragmentComponent::class])
class MainActivityModule {

    @Provides
    fun provideActivityName(): String {
        Log.i("Songyungi", "provideActivityName: ${MainActivity::class.java.simpleName}")
        return MainActivity::class.java.simpleName
    }
}