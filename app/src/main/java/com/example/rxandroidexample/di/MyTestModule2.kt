package com.example.rxandroidexample.di

import dagger.Module
import dagger.Provides

@Module(includes = [MyTestModule::class])
class MyTestModule2 {

    @Provides
    fun provideAge(): Int {
        return 99
    }
}