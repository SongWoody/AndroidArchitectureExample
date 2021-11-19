package com.example.rxandroidexample.di

import com.example.rxandroidexample.data.TestUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object TestModule {

    @Provides
    fun user(): TestUser {
        return TestUser()
    }
}