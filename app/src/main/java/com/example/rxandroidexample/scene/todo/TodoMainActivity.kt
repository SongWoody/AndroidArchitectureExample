package com.example.rxandroidexample.scene.todo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.rxandroidexample.R
import com.example.rxandroidexample.databinding.ActivityTodoMainBinding
import com.example.rxandroidexample.room.TodoDatabase

class TodoMainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityTodoMainBinding
    private val viewModel: TodoMainViewModel by viewModels {
        TodoMainViewModel.Factory(TodoDatabase.getInstance(application))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_todo_main)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this
    }
}