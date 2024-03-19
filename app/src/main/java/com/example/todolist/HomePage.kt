package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.todolist.DataUser.BuildData
import com.example.todolist.DataUser.RepoUser


class HomePage : AppCompatActivity() {
    val database:BuildData by lazy{
        BuildData.getDatabase(baseContext)
    }
    lateinit var repoUser: RepoUser

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repoUser= RepoUser(database.dao())

    }
}