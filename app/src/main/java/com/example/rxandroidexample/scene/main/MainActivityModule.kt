package com.example.rxandroidexample.scene.main

import android.util.Log
import com.example.rxandroidexample.di.scope.ActivityScope
import com.example.rxandroidexample.scene.main.fragment.MainFragment
import com.example.rxandroidexample.scene.main.fragment.MainFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Named

@Module(subcomponents = [MainFragmentComponent::class])
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

    @Binds
    @IntoMap
    @ClassKey(MainFragment::class)
    abstract fun bindInjectorFactory(factory: MainFragmentComponent.Factory): AndroidInjector.Factory<*>
}