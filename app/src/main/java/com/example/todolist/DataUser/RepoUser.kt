package com.example.todolist.DataUser

class RepoUser(private val dao: UserDao) {
    fun addUser(user: User){
        dao.addUser(user)
    }
    fun getName(nameofUser:String):String{
       return dao.getName(nameofUser)
    }
    fun getPassword(nameofUser: String):String{
        return dao.getPassword(nameofUser)
    }
    fun updatePassword(user: User){
        dao.updatePassword(user)
    }
}