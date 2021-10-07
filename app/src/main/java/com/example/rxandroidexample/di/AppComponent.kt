package com.example.rxandroidexample.di

import com.example.rxandroidexample.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent: AndroidInjector<MyApplication> {
    @Component.Factory
    interface Factory: AndroidInjector.Factory<MyApplication>
}