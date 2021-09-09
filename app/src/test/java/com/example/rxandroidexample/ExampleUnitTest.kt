package com.example.rxandroidexample

import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.PublishSubject
import org.junit.Test

import org.junit.Assert.*
import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

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
            it.onError(Throwable("zz"))
            it.onNext("World")
            it.onComplete()
        }

        source.subscribe(System.out::println){
            println(it.message)
        }
    }

    @Test
    fun runRxJust() {
        val source = Observable.just("Hello", "World")
        source.subscribe(System.out::println)
    }

    @Test
    fun runRxTest2() {
        val list = listOf("Hi","Hello","안녕")
        val source = Observable.fromIterable(list)
        source.subscribe(System.out::println)
    }

    @Test
    fun runRxTest3() {
        val publisher = Publisher<String> { subscriber ->
            subscriber.onNext("1")
            subscriber.onNext("2")
            subscriber.onNext("3")
            subscriber.onNext("4")
        }

        val source = Observable.fromPublisher(publisher)
        source.subscribe {
            println(it)
        }
    }

    @Test
    fun runRxTest4() {
        // Single
        val single = Single.just("Hello World")
        single.subscribe { s ->
            println(s)
        }

        // Maybe
        val maybe = Maybe.create<String> {
            it.onSuccess("maybe")
        }
        maybe.subscribe { s ->
            println(s)
        }

        // Completable
        val completer = Completable.create {
            it.onError(Throwable("error~"))
        }
        completer.subscribe( {
            println("success")
        }) {
            println("error: ${it.message}")
        }
    }

    @Test
    fun runColdStream() {
        val src = Observable.interval(1, TimeUnit.SECONDS)
        src.subscribe {
            println("#1: $it")
        }
        Thread.sleep(3000)
        src.subscribe {
            println("#2: $it")
        }
        Thread.sleep(3000)
    }

    @Test
    fun runHotStream() {
        val src = Observable.interval(1, TimeUnit.SECONDS).publish()
        src.connect()
        src.subscribe {
            println("#1: $it")
        }
        Thread.sleep(3000)
        src.subscribe {
            println("#2: $it")
        }
        Thread.sleep(3000)
    }

    @Test
    fun runAutoConnect() {
        // 두 개 이상 붙어야 발행된다.
        val src = Observable.interval(1, TimeUnit.SECONDS)
            .publish()
            .autoConnect(2)
        src.subscribe {
            println("#1: $it")
        }
        src.subscribe {
            println("#2: $it")
        }
        Thread.sleep(3000)
    }

    @Test
    fun runDisposable() {
        val src: Observable<Long> = Observable.interval(1, TimeUnit.SECONDS);
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(src.subscribe { println("#1: $it") })
        compositeDisposable.add(src.subscribe { println("#1: $it") })
        compositeDisposable.add(src.subscribe { println("#1: $it") })
        Thread.sleep(2000)
        compositeDisposable.add(src.subscribe { println("#2: $it") })
        compositeDisposable.add(src.subscribe { println("#2: $it") })
        Thread.sleep(2000)
        compositeDisposable.dispose()
        Thread.sleep(2000)
    }
}