package com.example.rxandroidexample

import io.reactivex.rxjava3.core.Observable
import org.junit.Test
import java.util.concurrent.TimeUnit

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

    @Test
    fun emptyAndNever() {
        Observable.empty<String>().doOnTerminate {
            println("empty HI")
        }.subscribe {
            println("#1 it")
        }

        Observable.never<String>().doOnTerminate {
            println("never HI")
        }.subscribe {
            println("#1 it")
        }

        Thread.sleep(1000)
    }

    @Test
    fun range() {
        Observable.range(1,10).subscribe {
            println("#$it")
        }
        Thread.sleep(1000)
    }

    @Test
    fun timer() {
        val src = Observable.timer(1, TimeUnit.SECONDS)
        println("구독")
        src.subscribe {
            println("실행")
        }
        println("Sleep")
        Thread.sleep(1000)
    }
}