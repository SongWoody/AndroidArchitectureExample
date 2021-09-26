package com.example.rxandroidexample.di

import com.example.rxandroidexample.data.MyClass
import org.junit.Test
import javax.inject.Inject

class DependencyInjectionTest {

    @Test
    fun exampleHelloWorld() {
        val myComponent = DaggerMyTestComponent.create()
        println("myComponent: string ${myComponent.getHello()}")
    }

    @Test
    fun exampleExtend() {
        val myComponent = DaggerMyTestComponent.create()
        println("myComponent: string ${myComponent.getWorld()}")
        println("myComponent: age ${myComponent.getAge()}")
    }

    @Test
    fun exampleMemberInjection() {
        val myClass = MyClass()

        println("myComponent: string ${myClass.myTitle}")
        println("myComponent: age ${myClass.myAge}")
    }
}