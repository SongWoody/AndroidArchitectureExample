package com.example.rxandroidexample.di

import android.content.Context
import android.content.SharedPreferences
import com.example.rxandroidexample.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideShredPreference(myApplication: MyApplication): SharedPreferences {
        return myApplication.getSharedPreferences("default", Context.MODE_PRIVATE)
    }
}