package com.example.rxandroidexample

import io.reactivex.rxjava3.core.*
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

    // onBackpressureBuffer
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

    // onBackpressureLatest
    @Test
    fun ex6() {
        Flowable.interval(10, TimeUnit.MILLISECONDS)
            .onBackpressureLatest()
            .map {
                println("발생 $it")
                return@map "$it"
            }
            .observeOn(Schedulers.newThread())
            .subscribe({
                Thread.sleep(500)
                println("소비 $it")
            }, {
                println(it.message)
            })
        Thread.sleep(10000)
    }

    // onBackpressureDrop
    @Test
    fun ex7() {
        Flowable.interval(10, TimeUnit.MILLISECONDS)
            .onBackpressureDrop {
                println("드롭 $it")
            }
            .map {
                println("발생 $it")
                return@map "$it"
            }
            .observeOn(Schedulers.newThread())
            .subscribe({
                Thread.sleep(50)
                println("소비 $it")
            }, {
                println(it.message)
            })
        Thread.sleep(20000)
    }

    @Test
    fun ex8() {
        Flowable.create(object : FlowableOnSubscribe<String> {
            override fun subscribe(emitter: FlowableEmitter<String>) {
                (1..3000).forEach {
                    if (emitter.isCancelled) {
                        return
                    }
                    emitter.onNext("$it")
                }
                emitter.onComplete()
            }
        }, BackpressureStrategy.BUFFER)
            .subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.newThread())
            .subscribe {
                Thread.sleep(20)
                println("소비 $it")
            }
        Thread.sleep(10000)
    }
}