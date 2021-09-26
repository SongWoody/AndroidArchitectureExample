package com.example.rxandroidexample.di

import android.content.Context
import com.example.rxandroidexample.room.TodoDatabase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setContext(context: Context): Builder
        @BindsInstance
        fun setTodoDatabase(db: TodoDatabase): Builder
        fun build(): AppComponent
    }

    fun todoDatabase(): TodoDatabase
}