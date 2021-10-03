package com.example.rxandroidexample.scene.main

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.rxandroidexample.R
import com.example.rxandroidexample.databinding.ActivityMainBinding
import com.example.rxandroidexample.scene.main.fragment.MainFragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Named("app")
    @Inject
    lateinit var appName: String
    @Named("activity")
    @Inject
    lateinit var activityName: String

    lateinit var binding: ActivityMainBinding

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
}