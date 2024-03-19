package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.DataUser.BuildData
import com.example.todolist.DataUser.RepoUser
import com.example.todolist.RecyclerView.RecyclerViewAdapter
import com.example.todolist.TaskData.BuildDataTask
import com.example.todolist.TaskData.RepoTask
import com.example.todolist.databinding.FragmentDisplayAllBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayAll.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayAll : Fragment() {
   lateinit var binding: FragmentDisplayAllBinding
    val database: BuildDataTask by lazy{
        BuildDataTask.getDatabase(requireContext())
    }
    val bundleName=arguments
    val nameofUser=  bundleName?.getString("mohamed")
    lateinit var repoTask: RepoTask
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        repoTask=RepoTask(database.daoTask())
        binding=FragmentDisplayAllBinding.inflate(inflater,container,false)
        val view =binding.root
        binding.btDisplayAll.setOnClickListener{
            Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()
            displayAll()
        }
        binding.btDisplayDone.setOnClickListener{
            Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()
            displayDone()
        }
        binding.btDisplayNotDone.setOnClickListener{
            Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()
            displayNotdone()
        }
       binding.btLogOut.setOnClickListener{
           Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()
           findNavController().navigate(R.id.logIn)
       }
        binding.btAdd.setOnClickListener{
            Toast.makeText(requireContext(), "Succusful", Toast.LENGTH_SHORT).show()
            val bundleNameOfUser=Bundle()
            bundleNameOfUser.putString("mohamed",nameofUser.toString())
            val edit=Edit()
            edit.arguments=bundleNameOfUser
            findNavController().navigate(R.id.edit)
        }
        binding.button.setOnClickListener{

            buttonSearch()
        }


        return view
    }

    private fun buttonSearch() {
        if (binding.edSerach.text != null) {
            if (repoTask.getOneTask(binding.edSerach.text.toString() ) != null) {
                Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()

                val action=DisplayAllDirections.actionDisplayAllToDisplayOne(binding.edSerach.text.toString())
                findNavController().navigate(action)
            } else {
                Snackbar.make(binding.btDisplayAll, "Task not exist", Snackbar.LENGTH_SHORT).show()
            }

        } else {
            Snackbar.make(binding.btDisplayAll, "Name require", Snackbar.LENGTH_SHORT).show()
            binding.edSerach.setError("Name require")
        }
    }

    private fun displayNotdone() {
        var tasks = repoTask.getDoneOrNotdone("not done")
        var adapter = RecyclerViewAdapter(tasks)
        binding.rec.adapter = adapter
        binding.rec.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun displayDone() {
        var tasks = repoTask.getDoneOrNotdone("done")
        var adapter = RecyclerViewAdapter(tasks)
        binding.rec.adapter = adapter
        binding.rec.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun displayAll() {
        var tasks = repoTask.getAll()
        var adapter = RecyclerViewAdapter(tasks)
        binding.rec.adapter = adapter
        binding.rec.layoutManager = LinearLayoutManager(requireContext())
    }


}