package com.example.rxandroidexample.data

import com.example.rxandroidexample.di.DaggerMyTestComponent
import javax.inject.Inject

class MyClass {
    @Inject
    lateinit var myTitle: String
    @Inject
    @JvmField
    public var myAge: Int = 0

    init {
        DaggerMyTestComponent.create().inject(this)
    }
}