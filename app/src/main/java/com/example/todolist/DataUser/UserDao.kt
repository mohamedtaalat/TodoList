package com.example.todolist.DataUser

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface  UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)
    @Query("Select passwordOfUser from User where nameOfUser =:nameofUser")
    fun getPassword(nameofUser:String):String
    @Query("Select nameOfUser from User where nameOfUser=:nameofUser")
    fun getName(nameofUser: String):String
    @Update
    fun updatePassword(user: User)
}