package com.example.rxandroidexample.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rxandroidexample.databinding.ViewTodoInfoCardBinding
import com.example.rxandroidexample.room.todo.Todo
import com.example.rxandroidexample.room.todo.TodoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CustomRecyclerViewAdapter(
    private val todoDb: TodoDatabase
): RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomVH>() {
    private var todoList: ArrayList<Todo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomVH {
        val binding = ViewTodoInfoCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomVH(binding, todoDb)
    }

    override fun onBindViewHolder(holder: CustomVH, position: Int) {
        holder.setData(todoList[position])
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(todoList: List<Todo>) {
        this.todoList.clear()
        this.todoList.addAll(todoList)
        notifyDataSetChanged()
    }

    class CustomVH(
        private val binding: ViewTodoInfoCardBinding,
        private val todoDb: TodoDatabase
    ): RecyclerView.ViewHolder(binding.root) {

        fun setData(todo: Todo) {
            binding.titleText.text = todo.title
            binding.subTitleText.text = todo.description
            binding.checkBox.isChecked = todo.isChecked
            binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
                todo.isChecked = isChecked
                CoroutineScope(Dispatchers.IO).launch {
                    todoDb.todoDao().update(todo)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(binding.root.context,"Update Success", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}