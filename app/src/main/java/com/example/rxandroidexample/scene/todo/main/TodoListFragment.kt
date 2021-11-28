package com.example.rxandroidexample.scene.todo.main

import android.os.Bundle
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = TodoListFragment()
    }

    private lateinit var binding: FragmentTodoListBinding
    private val viewModel: TodoMainViewModel by viewModels()

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
        binding.lifecycleOwner = this.viewLifecycleOwner

        initialize()
    }

    private fun initialize() {
        viewModel.navEvent.observe(this) {
            findNavController().navigate(it)
        }

        TodoDatabase.getInstance(this.requireActivity().application).todoDao().getAllTodoList().observe(this.viewLifecycleOwner) { todoList ->
            todoList ?: return@observe
            if (binding.todoRecyclerView.adapter == null) {
                binding.todoRecyclerView.layoutManager = LinearLayoutManager(this.requireActivity(), LinearLayoutManager.VERTICAL, false)
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