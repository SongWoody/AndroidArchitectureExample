package com.example.rxandroidexample

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Test
import java.util.concurrent.TimeUnit

class ExampleBackpressure {

    @Test
    fun ex1() {
        Observable.range(0, Int.MAX_VALUE)
            .map {
                println("$it 발행")
                return@map it
            }
            .subscribe {
                Thread.sleep(100)
                println("$it 소비")
            }

        Thread.sleep(10000)
    }

    /**
     * 발행과 소비의 균형이 맞지 않음
     */
    @Test
    fun ex2() {
        Observable.range(0, 100)
            .map {
                println("$it 준비")
                Thread.sleep(25)
                println("$it 발행")
                return@map it
            }
            .observeOn(Schedulers.newThread())
            .subscribe {
                Thread.sleep(100)
                println("$it 소비")
            }

        Thread.sleep(10000)
    }

    /**
     * Flowable 일정 수만큼 소비되지 않으면 발행하지 않음
     */
    @Test
    fun ex3() {
        Flowable.range(0, 200)
            .map {
                println("$it 발행 ${Thread.currentThread().name}")
                return@map "$it"
            }
            .observeOn(Schedulers.newThread())
            .subscribe {
                Thread.sleep(50)
                println("$it 소비 ${Thread.currentThread().name}")
            }
        Thread.sleep(10000)
    }

    // Interval 에 대한 Missing BackpressureException 예제
    @Test
    fun ex4() {
        Flowable.interval(10, TimeUnit.MILLISECONDS)
            .observeOn(Schedulers.io())
            .map {
                Thread.sleep(2000)
                println("발행 $it")
                return@map "$it"
            }
            .subscribe({
                println("소비 $it")
            }, {
                println(it.message)
            })
        Thread.sleep(10000)
    }

    @Test
    fun ex5() {
        Flowable.interval(10, TimeUnit.MILLISECONDS)
            .onBackpressureBuffer()
            .observeOn(Schedulers.newThread())
            .map {
                Thread.sleep(2000)
                println("발행 $it")
                return@map "$it"
            }
            .subscribe({
                println("소비 $it")
            }, {
                println(it.message)
            })
        Thread.sleep(10000)
    }
}