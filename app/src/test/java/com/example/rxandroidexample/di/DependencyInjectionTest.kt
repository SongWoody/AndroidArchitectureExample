package com.example.rxandroidexample.di

import com.example.rxandroidexample.data.MyClass
import com.example.rxandroidexample.data.MySetFoo
import org.junit.Assert
import org.junit.Test

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
        println("myComponent: string ${myComponent.getHi()}")
        println("myComponent: age ${myComponent.getAge()}")
    }

    @Test
    fun exampleMemberInjection() {
        val myClass = MyClass()

        println("myComponent: string ${myClass.myTitle}")
        println("myComponent: age ${myClass.myAge}")
    }

    @Test
    fun exampleSingleton() {
        val myComponent1 = DaggerMyTestComponent.create()
        println("myComponent1: SingletonRandom ${myComponent1.getSingletonRandom()}")
        println("myComponent1: SingletonRandom ${myComponent1.getSingletonRandom()}")
        println("myComponent1: SingletonRandom ${myComponent1.getSingletonRandom()}")
        println("myComponent1: SingletonRandom ${myComponent1.getSingletonRandom()}")
        Assert.assertEquals(myComponent1.getSingletonRandom(), myComponent1.getSingletonRandom())
        println()

        println("myComponent1: Random ${myComponent1.getRandom()}")
        println("myComponent1: Random ${myComponent1.getRandom()}")
        println("myComponent1: Random ${myComponent1.getRandom()}")
        println("myComponent1: Random ${myComponent1.getRandom()}")
        println("myComponent1: Random ${myComponent1.getRandom()}")
        println()

        val myComponent2 = DaggerMyTestComponent.create()
        println("myComponent2: string ${myComponent2.getSingletonRandom()}")
        println("myComponent2: string ${myComponent2.getSingletonRandom()}")
        println("myComponent2: string ${myComponent2.getSingletonRandom()}")
        println("myComponent2: string ${myComponent2.getSingletonRandom()}")
        Assert.assertEquals(myComponent2.getSingletonRandom(), myComponent2.getSingletonRandom())

        Assert.assertNotEquals(myComponent1.getSingletonRandom(), myComponent2.getSingletonRandom())
    }

    @Test
    fun exampleSet() {
        val component = DaggerSetComponent.create()
        val foo = MySetFoo()
        component.inject(foo)

        foo.strings?.forEach {
            println("it = $it")
        }
    }
}