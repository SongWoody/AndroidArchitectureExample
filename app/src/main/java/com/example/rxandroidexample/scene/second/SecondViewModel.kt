package com.example.rxandroidexample.scene.second

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.rxandroidexample.data.TestUser

class SecondViewModel @ViewModelInject constructor(
    user: TestUser
) : ViewModel() {
    val name = user.name
}