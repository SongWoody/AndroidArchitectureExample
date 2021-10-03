package com.example.rxandroidexample.scene.main.fragment

import com.example.rxandroidexample.di.scope.FragmentScope
import dagger.Module
import dagger.Provides
import javax.inject.Named
import kotlin.random.Random

@Module
class MainFragmentModule {
    @Named("fragment")
    @Provides
    @FragmentScope
    fun provideFragment(): String {
        return "Main Fragment"
    }
}