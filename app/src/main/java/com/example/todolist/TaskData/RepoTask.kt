package com.example.todolist.TaskData



class RepoTask(private val daotask: TaskDao) {
    fun addTask(tasks: Tasks){
        daotask.addTask(tasks)
    }

    fun getOneTask(nameofTask:String):Tasks{
        return daotask.selectTask(nameofTask)
    }
    fun getDoneOrNotdone(doneOrNotdone: String):List<Tasks>{
        return daotask.getDoneOrNotDone(doneOrNotdone)
    }
    fun getAll():List<Tasks>{
        return daotask.toGetAll()
    }
    fun deleteTask(tasks: Tasks){
        daotask.deleteTask(tasks)
    }
}