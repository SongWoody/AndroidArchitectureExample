package com.example.rxandroidexample.di

import dagger.Component

@Component(modules = [MyTestModule2::class])
interface MyTestComponent {

    fun getString(): String
    fun getAge(): Int
}