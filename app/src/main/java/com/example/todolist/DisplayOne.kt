package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolist.TaskData.BuildDataTask
import com.example.todolist.TaskData.RepoTask
import com.example.todolist.databinding.FragmentDisplayOneBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayOne : Fragment() {
    val args:DisplayOneArgs by navArgs()
    lateinit var binding: FragmentDisplayOneBinding
    val database: BuildDataTask by lazy{
        BuildDataTask.getDatabase(requireContext())
    }
    lateinit var repoTask: RepoTask

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        repoTask= RepoTask(database.daoTask())
        binding=FragmentDisplayOneBinding.inflate(inflater,container,false)
        val view=binding.root
        val nameOfTask=args.nameOfTask

        binding.tvName2.text=repoTask.getOneTask(nameOfTask).name
        binding.tvContent2.text=repoTask.getOneTask(nameOfTask).content
        binding.tvTime2.text=repoTask.getOneTask(nameOfTask).time
        binding.tvDone2.text=repoTask.getOneTask(nameOfTask).doneOrNotdone

        binding.btReturn.setOnClickListener {
            Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.displayAll)
        }
        binding.btDelete.setOnClickListener {
            repoTask.deleteTask(repoTask.getOneTask(nameOfTask))
            findNavController().navigate(R.id.displayAll)
        }
        return view
    }



}