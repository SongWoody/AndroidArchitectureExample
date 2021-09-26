package com.example.rxandroidexample.di

import com.example.rxandroidexample.di.qualifier.Hi
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

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

    @Provides
    @Singleton
    @Named("singletonRandom")
    fun provideSingletonRandom(): Int {
        return (0 .. 100000).random()
    }

    @Provides
    @Named("random")
    fun provideRandom(): Int {
        return (0 .. 100000).random()
    }
}