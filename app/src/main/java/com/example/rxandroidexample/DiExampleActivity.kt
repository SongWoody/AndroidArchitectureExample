package com.example.rxandroidexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.rxandroidexample.databinding.ActivityDiExampleBinding

class DiExampleActivity : AppCompatActivity() {
    lateinit var binding: ActivityDiExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_di_example)
    }
}