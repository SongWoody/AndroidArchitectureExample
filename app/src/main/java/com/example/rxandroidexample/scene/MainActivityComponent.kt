package com.example.rxandroidexample.scene

import com.example.rxandroidexample.di.scope.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent: AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<MainActivity>
}