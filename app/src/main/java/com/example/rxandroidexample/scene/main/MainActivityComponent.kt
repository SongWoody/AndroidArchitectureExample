package com.example.rxandroidexample.scene.main

import com.example.rxandroidexample.di.scope.ActivityScope
import com.example.rxandroidexample.scene.main.fragment.MainFragmentComponent
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent: AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<MainActivity>
}