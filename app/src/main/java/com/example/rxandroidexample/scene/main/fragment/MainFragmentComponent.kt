package com.example.rxandroidexample.scene.main.fragment

import com.example.rxandroidexample.di.scope.FragmentScope
import dagger.BindsInstance
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [MainFragmentModule::class])
interface MainFragmentComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun setFragment(fragment: MainFragment): Builder
        fun build(): MainFragmentComponent
    }

    fun inject(fragment: MainFragment)
}