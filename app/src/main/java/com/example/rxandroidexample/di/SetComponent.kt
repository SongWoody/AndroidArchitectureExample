package com.example.rxandroidexample.di

import com.example.rxandroidexample.data.MySetFoo
import dagger.Component

@Component(modules = [SetModule::class])
interface SetComponent {
    fun inject(obj: MySetFoo)
}