package com.example.rxandroidexample.scene.main

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.rxandroidexample.MyApplication
import com.example.rxandroidexample.R
import com.example.rxandroidexample.databinding.ActivityMainBinding
import com.example.rxandroidexample.scene.main.fragment.MainFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Named("app")
    @Inject
    lateinit var appName: String
    @Named("activity")
    @Inject
    lateinit var activityName: String
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    lateinit var binding: ActivityMainBinding
    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        Log.i("MainActivity", appName)
        Log.i("MainActivity", activityName)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commit()

        Log.i("MainActivity", "activityName $activityName")
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}