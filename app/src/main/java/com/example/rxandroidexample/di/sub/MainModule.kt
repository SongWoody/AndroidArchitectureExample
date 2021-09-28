package com.example.rxandroidexample.di.sub

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MainModule {

    @Provides
    fun provideName(): String {
        return "Song"
    }

    @Provides
    fun provideNumber(): Int {
        return 99
    }


}