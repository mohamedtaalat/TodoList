package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todolist.TaskData.BuildDataTask
import com.example.todolist.TaskData.RepoTask
import com.example.todolist.TaskData.Tasks
import com.example.todolist.databinding.FragmentEditBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Edit.newInstance] factory method to
 * create an instance of this fragment.
 */
class Edit : Fragment() {
   lateinit var binding: FragmentEditBinding
    val database: BuildDataTask by lazy{
        BuildDataTask.getDatabase(requireContext())
    }
    lateinit var repoTask: RepoTask
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle=arguments
        val nameOfUser=bundle?.getString("mohamed")
        binding= FragmentEditBinding.inflate(inflater,container,false)
        val view =binding.root
        repoTask= RepoTask(database.daoTask())
        binding.btAdd3.setOnClickListener{
            val listTasks=Tasks(binding.edNameTask.text.toString(),binding.edContent.text.toString(),binding.edTime.text.toString(),binding.edDone.text.toString())

            repoTask.addTask(listTasks)
            Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.displayAll)
        }
        return view
    }


}