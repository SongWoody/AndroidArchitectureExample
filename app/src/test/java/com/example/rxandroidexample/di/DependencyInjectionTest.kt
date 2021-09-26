package com.example.rxandroidexample.di

import org.junit.Test
import javax.inject.Inject

class DependencyInjectionTest {

    @Test
    fun exampleHelloWorld() {
        val myComponent = DaggerMyTestComponent.create()
        println("myComponent: ${myComponent.getString()}")
    }
}