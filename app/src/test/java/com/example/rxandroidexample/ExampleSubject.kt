package com.example.rxandroidexample

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import org.junit.Test

class ExampleSubject {

    @Test
    fun ex1() {
        val src = PublishSubject.create<String>()
        src.subscribe(
            {
                println("A: $it")
            },
            {
                print("${it.message}")
            }, {
                println("A: complete")
            }
        )
        src.subscribe(
            {
                println("B: $it")
            },
            {
                print("${it.message}")
            }, {
                println("B: complete")
            }
        )
        src.onNext("11")
        src.onNext("11")
        src.onNext("11")

        Thread.sleep(3000)
    }
}