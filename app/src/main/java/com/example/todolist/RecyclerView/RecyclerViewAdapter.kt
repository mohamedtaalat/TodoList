package com.example.todolist.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.TaskData.Tasks


 class RecyclerViewAdapter(var tasks:List<Tasks>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val nameOfTask:TextView=itemview.findViewById(R.id.tvName)
        val contentOfTask:TextView=itemview.findViewById(R.id.tvContent)
        val timeOfTask:TextView=itemview.findViewById(R.id.tvTime)
        val doneOrNotdone:TextView=itemview.findViewById(R.id.tvDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.activity_item_inrec,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameOfTask.text=tasks.get(position).name
        holder.contentOfTask.text=tasks.get(position).content
        holder.doneOrNotdone.text=tasks.get(position).doneOrNotdone
        holder.timeOfTask.text=tasks.get(position).time
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}