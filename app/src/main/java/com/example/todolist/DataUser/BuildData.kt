package com.example.todolist.DataUser

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class BuildData: RoomDatabase() {
    abstract fun dao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: BuildData? = null
        fun getDatabase(context: Context): BuildData {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BuildData::class.java,
                    " User"
                ).allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}