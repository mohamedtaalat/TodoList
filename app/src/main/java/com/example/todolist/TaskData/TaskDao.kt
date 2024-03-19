package com.example.todolist.TaskData

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(tasks: Tasks)
    @Query("Select * from Tasks where nameOfTask=:nameofTask")
    fun selectTask(nameofTask:String):Tasks
    @Query("Select * from Tasks where doneOrNotdone=:doneorNotdone")
    fun getDoneOrNotDone(doneorNotdone:String):List<Tasks>
    @Query("Select * from Tasks ")
    fun toGetAll():List<Tasks>
    @Delete
    fun deleteTask(tasks: Tasks)
}