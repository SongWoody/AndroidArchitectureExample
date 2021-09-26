package com.example.rxandroidexample.data

import com.example.rxandroidexample.di.DaggerMyTestComponent
import com.example.rxandroidexample.di.Hi
import dagger.MembersInjector
import javax.inject.Inject
import javax.inject.Named

class MyClass {
    @Inject
    @Named("world")
    lateinit var myTitle: String
    @Inject
    @JvmField
    var myAge: Int = 0

    init {
        DaggerMyTestComponent.create().inject(this)
    }
}