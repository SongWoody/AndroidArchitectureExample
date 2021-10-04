package com.example.rxandroidexample.di

import android.content.Context
import android.content.SharedPreferences
import com.example.rxandroidexample.MyApplication
import com.example.rxandroidexample.di.scope.ActivityScope

import com.example.rxandroidexample.scene.main.MainActivity
import com.example.rxandroidexample.scene.main.MainActivityModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class AppModule {

    companion object {
        @Provides
        @Singleton
        fun provideShredPreference(myApplication: MyApplication): SharedPreferences {
            return myApplication.getSharedPreferences("default", Context.MODE_PRIVATE)
        }
    }

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}