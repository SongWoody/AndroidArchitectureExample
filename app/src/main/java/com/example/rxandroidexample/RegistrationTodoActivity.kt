package com.example.rxandroidexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rxandroidexample.databinding.ActivityRegistrationTodoBinding
import com.example.rxandroidexample.room.TodoDatabase

class RegistrationTodoActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityRegistrationTodoBinding
    val viewModel: RegistrationTodoViewModel by viewModels {
        object: ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(RegistrationTodoViewModel::class.java)) {
                    return RegistrationTodoViewModel(TodoDatabase.getInstance(application)) as T
                }
                throw IllegalArgumentException("Factory cannot make ViewModel of type ${modelClass.simpleName}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration_todo)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this
    }
}