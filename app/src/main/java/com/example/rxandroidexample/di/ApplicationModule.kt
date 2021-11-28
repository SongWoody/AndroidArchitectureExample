package com.example.rxandroidexample.di

import android.app.Application
import android.util.Log
import com.example.rxandroidexample.room.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideTodoDb(@ApplicationContext context: Application): TodoDatabase {
        Log.i("Woody","todoDb")
        return TodoDatabase.getInstance(context)
    }
}