package com.example.rxandroidexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.rxandroidexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.todoButton.setOnClickListener {
            startActivity(Intent(this, TodoMainActivity::class.java))
        }

        binding.diButton.setOnClickListener {
            startActivity(Intent(this, DiExampleActivity::class.java))
        }
    }
}