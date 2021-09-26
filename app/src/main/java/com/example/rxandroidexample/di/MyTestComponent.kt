package com.example.rxandroidexample.di

import com.example.rxandroidexample.data.MyClass
import dagger.Component

@Component(modules = [MyTestModule2::class])
interface MyTestComponent {

    fun getString(): String
    fun getAge(): Int

    fun inject(myClass: MyClass)
}