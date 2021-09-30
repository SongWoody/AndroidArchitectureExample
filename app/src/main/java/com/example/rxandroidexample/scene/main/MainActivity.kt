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
import com.example.rxandroidexample.scene.todo.TodoMainActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).appComponent.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.todoButton.setOnClickListener {
            startActivity(Intent(this, TodoMainActivity::class.java))
        }

        binding.diButton.setOnClickListener {
            startActivity(Intent(this, DiExampleActivity::class.java))
        }
    }
}