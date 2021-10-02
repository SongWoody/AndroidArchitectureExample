package com.example.rxandroidexample.scene.main

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.rxandroidexample.scene.DiExampleActivity
import com.example.rxandroidexample.MyApplication
import com.example.rxandroidexample.R
import com.example.rxandroidexample.databinding.ActivityMainBinding
import com.example.rxandroidexample.scene.main.fragment.MainFragment
import com.example.rxandroidexample.scene.todo.TodoMainActivity
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var component: MainActivityComponent
    @Inject
    lateinit var activityName: String
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        component = (application as MyApplication).appComponent
            .mainActivityComponentBuilder()
            .setModule(MainActivityModule())
            .setActivity(this)
            .build()
        component.inject(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commit()

        Log.i("MainActivity", "activityName $activityName")
    }
}