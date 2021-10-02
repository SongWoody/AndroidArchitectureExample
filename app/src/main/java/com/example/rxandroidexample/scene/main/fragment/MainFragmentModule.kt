package com.example.rxandroidexample.scene.main.fragment

import com.example.rxandroidexample.di.scope.FragmentScope
import dagger.Module
import dagger.Provides
import kotlin.random.Random

@Module
class MainFragmentModule {
    @Provides
    @FragmentScope
    fun provideInt(): Int {
        return Random(2).nextInt()
    }
}