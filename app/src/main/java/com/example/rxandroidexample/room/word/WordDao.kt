package com.example.rxandroidexample.room.word

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {
    @Insert
    fun insert(word: Word)

    @Update
    fun update(word: Word)

    @Delete
    fun delete(word: Word)

    @Query("SELECT * FROM Word")
    fun getAllTodoList(): LiveData<List<Word>>
}