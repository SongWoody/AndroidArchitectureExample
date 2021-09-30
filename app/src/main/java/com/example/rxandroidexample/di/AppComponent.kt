package com.example.rxandroidexample.di

import com.example.rxandroidexample.scene.main.MainActivity
import com.example.rxandroidexample.MyApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: MyApplication,
            appModule: AppModule
        ): AppComponent
    }

    fun inject(activity: MainActivity)
}