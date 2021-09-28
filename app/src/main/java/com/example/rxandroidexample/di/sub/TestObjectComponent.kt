package com.example.rxandroidexample.di.sub

import dagger.Subcomponent

@Subcomponent
interface TestObjectComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): TestObjectComponent
    }

    fun getTestObj(): TestObject
}