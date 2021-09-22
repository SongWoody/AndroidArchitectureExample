package com.example.rxandroidexample.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        private const val DB_NAME = "todo-database"
        private var instance: TodoDatabase? = null

        fun getInstance(context: Context):TodoDatabase {
            return instance ?: synchronized(this) {
                return buildDatabase(context)
            }
        }

        private fun buildDatabase(context: Context): TodoDatabase {
            return Room.databaseBuilder(
                context,
                TodoDatabase::class.java,
                DB_NAME
            ).build()
        }
     }
}