package com.example.rxandroidexample.di

import android.content.Context
import android.content.SharedPreferences
import com.example.rxandroidexample.MyApplication
import com.example.rxandroidexample.scene.main.MainActivity
import com.example.rxandroidexample.scene.main.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Named
import javax.inject.Singleton

@Module(subcomponents = [MainActivityComponent::class])
abstract class AppModule {

    companion object {
        @Named("app")
        @Provides
        @Singleton
        fun provideString(): String {
            return "My Application"
        }

        @Provides
        @Singleton
        fun provideShredPreference(myApplication: MyApplication): SharedPreferences {
            return myApplication.getSharedPreferences("default", Context.MODE_PRIVATE)
        }
    }


    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindAndroidInjectorFactory(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>
}