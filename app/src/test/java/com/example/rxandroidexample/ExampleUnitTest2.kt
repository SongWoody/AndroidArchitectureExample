package com.example.rxandroidexample

import io.reactivex.rxjava3.core.Observable
import org.junit.Test

// rx operation
class ExampleUnitTest2 {
    @Test
    fun defer() {
        val justSrc = Observable.just(
            System.currentTimeMillis()
        )

        val deferSrc = Observable.defer {
            Observable.just(System.currentTimeMillis())
        }

        println("#1 current time ${System.currentTimeMillis()}")
        Thread.sleep(5000)
        println("#2 current time ${System.currentTimeMillis()}")
        justSrc.subscribe {
            println("#1 justSrc $it")
        }
        deferSrc.subscribe {
            println("#2 deferSrc $it")
        }
    }
}