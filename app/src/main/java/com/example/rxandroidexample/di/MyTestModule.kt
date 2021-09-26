package com.example.rxandroidexample.di

import dagger.Module
import dagger.Provides

@Module
class MyTestModule {

    @Provides
    fun provideHelloWorld(): String {
        return "Hello World"
    }
}