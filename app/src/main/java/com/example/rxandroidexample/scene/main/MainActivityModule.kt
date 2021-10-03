package com.example.rxandroidexample.scene.main

import android.util.Log
import com.example.rxandroidexample.di.scope.ActivityScope
import com.example.rxandroidexample.di.scope.FragmentScope
import com.example.rxandroidexample.scene.main.fragment.MainFragment
import com.example.rxandroidexample.scene.main.fragment.MainFragmentModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module
abstract class MainActivityModule {
    companion object {
        @Named("activity")
        @Provides
        @ActivityScope
        fun provideActivityName(): String {
            Log.i("Songyungi", "provideActivityName: ${MainActivity::class.java.simpleName}")
            return MainActivity::class.java.simpleName
        }
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun mainFragment(): MainFragment
}