package com.example.rxandroidexample.room

import androidx.room.*

@Dao
interface TodoDao {
    @Insert
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)

    @Query("SELECT * FROM TODO")
    fun getAllTodoList(): List<Todo>
}