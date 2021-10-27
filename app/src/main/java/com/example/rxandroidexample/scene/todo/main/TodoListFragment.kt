package com.example.rxandroidexample.scene.todo.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rxandroidexample.databinding.FragmentTodoListBinding
import com.example.rxandroidexample.room.TodoDatabase

class TodoListFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = TodoListFragment()
    }

    private lateinit var binding: FragmentTodoListBinding
    private val viewModel: TodoMainViewModel by viewModels {
        TodoMainViewModel.Factory(TodoDatabase.getInstance(this.requireActivity().application))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initialize()
    }

    private fun initialize() {
        viewModel.navEvent.observe(this) {
            findNavController().navigate(it)
        }
    }
}