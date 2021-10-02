package com.example.rxandroidexample.scene.main

import com.example.rxandroidexample.di.scope.ActivityScope
import com.example.rxandroidexample.scene.main.fragment.MainFragmentComponent
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
@ActivityScope
interface MainActivityComponent {
    val mainFragmentComponentBuilder: MainFragmentComponent.Builder

    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun setModule(module: MainActivityModule): Builder
        @BindsInstance
        fun setActivity(activity: MainActivity): Builder
        fun build(): MainActivityComponent
    }
}