package com.example.rxandroidexample.room.word

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 2)
abstract class WordDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        private const val DB_NAME = "word-database"
        private var instance: WordDatabase? = null

        fun getInstance(context: Context): WordDatabase {
            return instance ?: synchronized(this) {
                return buildDatabase(context)
            }
        }

        private fun buildDatabase(context: Context): WordDatabase {
            return Room.databaseBuilder(
                context,
                WordDatabase::class.java,
                DB_NAME
            ).build()
        }
     }
}