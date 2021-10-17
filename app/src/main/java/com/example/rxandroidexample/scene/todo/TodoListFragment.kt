package com.example.rxandroidexample.scene.todo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxandroidexample.databinding.FragmentTodoListBinding
import com.example.rxandroidexample.room.TodoDatabase
import com.example.rxandroidexample.view.CustomRecyclerViewAdapter

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

        viewModel.todoDb.todoDao().getAllTodoList().observe(this.viewLifecycleOwner) { todoList ->
            Log.i("Woody", "it = ${todoList.size}")
            binding.todoRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            if (binding.todoRecyclerView.adapter == null) {
                CustomRecyclerViewAdapter(
                    TodoDatabase.getInstance(this.requireActivity().application)
                ).apply {
                    this.setItems(todoList)
                }.also {
                    binding.todoRecyclerView.adapter = it
                }
            }  else {
                (binding.todoRecyclerView.adapter as? CustomRecyclerViewAdapter)?.setItems(todoList)
            }
        }
    }
}