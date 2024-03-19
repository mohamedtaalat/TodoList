package com.example.todolist.TaskData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Tasks::class], version = 3, exportSchema = false)
abstract class BuildDataTask: RoomDatabase() {
    abstract fun daoTask(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: BuildDataTask? = null
        fun getDatabase(context: Context): BuildDataTask {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BuildDataTask::class.java,
                    " Tasks"
                ).allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}