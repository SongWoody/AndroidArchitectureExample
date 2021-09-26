package com.example.rxandroidexample.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module()
class MyTestModule2 {

    @Provides
    @Named("hello")
    fun provideHello(): String {
        return "Hello"
    }

    @Provides
    @Named("world")
    fun provideWorld(): String {
        return "World"
    }

    @Provides
    @Hi
    fun provideHi(): String {
        return "Hi"
    }

    @Provides
    fun provideAge(): Int {
        return 99
    }
}