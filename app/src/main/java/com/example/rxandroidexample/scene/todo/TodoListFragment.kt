package com.example.rxandroidexample.scene.todo

import android.os.Bundle
import android.util.Log
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
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initialize()
        return binding.root
    }

    private fun initialize() {
        viewModel.navEvent.observe(this) {
            findNavController().navigate(it)
        }

        viewModel.todoDb.todoDao().getAllTodoList().observe(this.viewLifecycleOwner) {
            Log.i("Woody", "it = ${it.size}")
        }
    }
}