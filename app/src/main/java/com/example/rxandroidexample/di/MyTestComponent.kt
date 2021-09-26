package com.example.rxandroidexample.di

import com.example.rxandroidexample.data.MyClass
import dagger.Component
import javax.inject.Named

@Component(modules = [MyTestModule2::class])
interface MyTestComponent {

    @Named("hello")
    fun getHello(): String
    @Named("world")
    fun getWorld(): String

    fun getAge(): Int

    fun inject(myClass: MyClass)
}