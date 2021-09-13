package com.example.rxandroidexample

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Test

class ExampleUnitTest3 {

    @Test
    fun schedulerList() {
        val io = Schedulers.io() // db, network
        val computation = Schedulers.computation() // 단순 반복작업, 콜백 처리용(블코킹 이슈가 발생하는 곳에 사용 x)
        val trampoline = Schedulers.trampoline() // 새로운 스레드를 생성하지 않고 현재 스레드에 무한한 크기의 큐를 생성(FIFO)
        val newThread = Schedulers.newThread() // new Thread

        val android = AndroidSchedulers.mainThread() // android 용
    }

    @Test
    fun schedulerEx1() {
        val src = Observable.create<Int> { emitter ->
            IntRange(1,5).forEach {
                println("#Subs on \"${Thread.currentThread().name}\" : $it")
                emitter.onNext(it)
                Thread.sleep(100)
            }
            emitter.onComplete()
        }

        src.subscribe {
            println(" #Obsv on ${Thread.currentThread().name} : $it")
        }
        println("//////")
        src.subscribeOn(Schedulers.io())
            .subscribe {
                println(" #Obsv on ${Thread.currentThread().name} : $it")
            }
        Thread.sleep(1000)
        println("//////")
        src.observeOn(Schedulers.computation())
            .subscribeOn(Schedulers.io())
            .subscribe {
                println(" #Obsv on ${Thread.currentThread().name} : $it")
            }
        Thread.sleep(1000)
    }

    // 안드로이드 네트워크 통신 예
    @Test
    fun schedulerEx2() {
        val src = Observable.create<String> {
            Thread.sleep(1000)
            it.onNext("result")
        }

        // AndroidSchedulers.mainThread 은 제이 유닛에서 exception 발생
        src.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                println("Update UI: $it")
            }

    }
}