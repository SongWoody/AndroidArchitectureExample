package com.example.rxandroidexample.data

import com.example.rxandroidexample.di.DaggerMyTestComponent
import dagger.MembersInjector
import javax.inject.Inject

class MyClass {
    @Inject
    lateinit var myTitle: String
    @Inject
    @JvmField
    var myAge: Int = 0

    init {
        DaggerMyTestComponent.create().inject(this)
    }
}