package com.example.rxandroidexample

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun runRxTest() {
        val items = PublishSubject.create<Int>().apply {
            onNext(1)
            onNext(2)
            onNext(3)
            onNext(4)
            onNext(5)
        }

        items
            .filter { item ->
                item % 2 == 0
            }.subscribe { item ->
                println("item:  $item")
            }

        items.onNext(6)
        items.onNext(7)
        items.onNext(8)
        items.onNext(9)
    }

    @Test
    fun runRxTest1() {
        val source = Observable.create<String> {
            it.onNext("Hello")
            it.onNext("World")
            it.onComplete()
        }

        source.subscribe(System.out::println)
    }
}