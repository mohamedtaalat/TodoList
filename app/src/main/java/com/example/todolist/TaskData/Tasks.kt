package com.example.todolist.TaskData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["nameOfTask"],
    unique = true)],tableName = "Tasks")
data class Tasks(
    @ColumnInfo(name = "nameOfTask")
    @PrimaryKey
    val name:String,
    val content:String,
    val time:String,
    val doneOrNotdone:String

)
