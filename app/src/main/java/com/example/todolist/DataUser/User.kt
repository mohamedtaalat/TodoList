package com.example.todolist.DataUser

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["nameOfUser"],
    unique = true)],tableName = "User")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "nameOfUser")
    val nameOfUser:String,
    val passwordOfUser:String
)
