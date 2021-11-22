package com.example.rxandroidexample.scene.second

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class SecondViewModel @ViewModelInject constructor() : ViewModel() {
    val name = "Hilt ViewModel Test"
}