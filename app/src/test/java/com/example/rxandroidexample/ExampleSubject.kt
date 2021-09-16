package com.example.rxandroidexample

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.UnicastSubject
import org.junit.Test
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

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

    /**
     * Subject 는 HotStream 이다.
     */
    @Test
    fun ex2() {
        val src = PublishSubject.create<String>()
        src.onNext("zz")
        src.onNext("ee")
        src.onNext("33")
        src.subscribe {
            println("it = $it")
        }


        src.onNext("Hot")
        src.onNext("Stream")

        Thread.sleep(1000)
    }

    @Test
    fun ex3() {
        val src1 = Observable.interval(1, TimeUnit.SECONDS)
            .map {
                return@map "1 초마다 로그 $it"
            }
        val src2 = Observable.interval(2, TimeUnit.SECONDS)
            .map {
                return@map "2 초마다 로그 $it"
            }
        val subject = PublishSubject.create<String>()

        src1.subscribe(subject)
        src2.subscribe(subject)

        subject.subscribe {
            println(it)
        }

        Thread.sleep(10000)
    }

    /**
     * toSerialized 스레드 셰이프 보장
     */
    @Test
    fun ex4() {
        val counter = AtomicInteger()
        val subject = PublishSubject.create<Int>()
            .toSerialized() // toSerialized 스레드 셰이프 보장
        subject.doOnNext {
            counter.incrementAndGet()
        }.doOnNext {
            counter.decrementAndGet()
        }.filter {
            counter.get() != 0
        }.subscribe {
            println("it is $it")
        }

        val runnable = {
            (1..10000).forEach {
                Thread.sleep(1)
                subject.onNext(it)
            }
        }
        Thread(runnable).start()
        Thread(runnable).start()
        Thread.sleep(10000)
        println("종료")
    }

    // AsyncSubject // onComplete 가 불리기 전 값
    @Test
    fun ex5() {
        val subject = AsyncSubject.create<Int>()
        subject.subscribe { println("A $it") }
        subject.onNext(1)
        subject.onNext(2)
        subject.subscribe { println("B $it") }
        subject.onNext(3)
        subject.onNext(4)
        subject.onComplete()
        subject.subscribe { println("C $it") }

        Thread.sleep(1000)
        subject.onNext(5)
        subject.subscribe { println("D $it") }
    }

    /**
     * UnicastSubject 구독이 시작되면 버퍼에 있는던 아이템을 모두 발행하고 버퍼를 비운다.
     * 구독자를 여러 개 둘 수 없다.
     */
    @Test
    fun ec6() {
        val subject = UnicastSubject.create<Long>()
        Observable.interval(1, TimeUnit.SECONDS)
            .subscribe(subject)
        Thread.sleep(3000)
        subject.subscribe {
            println("$it") // 구독하는 순간 버퍼를 비우므로 0 부터 시작
        }
        Thread.sleep(2000)
    }

    @Test
    fun ec7() {
        val subject = PublishSubject.create<Long>()
        Observable.interval(1, TimeUnit.SECONDS)
            .subscribe(subject)
        Thread.sleep(3000)
        subject.subscribe {
            println("$it") // 3부터 시작
        }
        Thread.sleep(4000)
    }
}