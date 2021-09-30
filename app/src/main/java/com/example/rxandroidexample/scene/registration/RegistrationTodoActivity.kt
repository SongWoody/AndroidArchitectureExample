package com.example.rxandroidexample.scene.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.rxandroidexample.R
import com.example.rxandroidexample.databinding.ActivityRegistrationTodoBinding
import com.example.rxandroidexample.room.TodoDatabase

class RegistrationTodoActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityRegistrationTodoBinding
    private val viewModel: RegistrationTodoViewModel by viewModels {
        RegistrationTodoViewModel.Factory(TodoDatabase.getInstance(application))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration_todo)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this
    }
}