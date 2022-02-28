package com.example.rxandroidexample.scene.todo.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.rxandroidexample.databinding.FragmentTodoRegistrationTodoBinding
import com.example.rxandroidexample.room.todo.TodoDatabase

class TodoRegistrationFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = TodoRegistrationFragment()
    }

    lateinit var binding: FragmentTodoRegistrationTodoBinding
    private val viewModel: TodoRegistrationViewModel by viewModels {
        TodoRegistrationViewModel.Factory(TodoDatabase.getInstance(this.requireActivity().application))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoRegistrationTodoBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}