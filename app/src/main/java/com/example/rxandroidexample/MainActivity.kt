package com.example.rxandroidexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.rxandroidexample.databinding.ActivityMainBinding
import com.example.rxandroidexample.room.Todo
import com.example.rxandroidexample.room.TodoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val newTodo = Todo("test","test todo")
        val db = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            "todo-database"
        ).build()

        dataBinding.addButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.todoDao().insert(newTodo)
            }
        }

        dataBinding.selectButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val todoList = db.todoDao().getAllTodoList()
                todoList.map { "id: ${it.id} title: ${it.title} " }.forEach {
                    dataBinding.test.append("$it ,")
                }

            }
        }



    }
}