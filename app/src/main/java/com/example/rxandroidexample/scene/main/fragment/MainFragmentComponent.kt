package com.example.rxandroidexample.scene.main.fragment

import com.example.rxandroidexample.di.scope.FragmentScope
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(modules = [MainFragmentModule::class])
interface MainFragmentComponent: AndroidInjector<MainFragment> {
    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<MainFragment>
}