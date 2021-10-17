package com.example.rxandroidexample.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxandroidexample.databinding.ViewTodoInfoCardBinding
import com.example.rxandroidexample.room.Todo

class CustomRecyclerViewAdapter: RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomVH>() {
    private var todoList: ArrayList<Todo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomVH {
        val binding = ViewTodoInfoCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomVH(binding)
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

    class CustomVH(val binding: ViewTodoInfoCardBinding): RecyclerView.ViewHolder(binding.root) {

        fun setData(todo: Todo) {
            binding.titleText.text = todo.title
            binding.subTitleText.text = todo.description
        }
    }
}