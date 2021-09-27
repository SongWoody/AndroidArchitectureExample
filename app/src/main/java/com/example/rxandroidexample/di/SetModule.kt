package com.example.rxandroidexample.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet

@Module
class SetModule {

    @Provides
    @IntoSet
    fun provideHello(): String {
        return "Hello"
    }

    @Provides
    @IntoSet
    fun provideWorld(): String {
        return "World"
    }

//    @Provides
//    @ElementsIntoSet
//    fun provideSet(): Set<String> {
//        return HashSet(arrayListOf("Charles","Runa"))
//    }
}