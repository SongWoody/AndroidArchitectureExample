package com.example.rxandroidexample.di

import dagger.Component

@Component(modules = [MyTestModule::class])
interface MyTestComponent {

    fun getString(): String
}