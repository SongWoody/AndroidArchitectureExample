package com.example.rxandroidexample.di

import com.example.rxandroidexample.data.MyClass
import com.example.rxandroidexample.di.qualifier.Hi
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [MyTestModule2::class])
interface MyTestComponent {

    @Named("hello")
    fun getHello(): String

    @Named("world")
    fun getWorld(): String

    @Hi
    fun getHi(): String

    fun getAge(): Int

    @Named("singletonRandom")
    fun getSingletonRandom(): Int

    @Named("random")
    fun getRandom(): Int

    fun inject(myClass: MyClass)
}