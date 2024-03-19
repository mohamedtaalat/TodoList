package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todolist.DataUser.BuildData
import com.example.todolist.DataUser.RepoUser
import com.example.todolist.databinding.FragmentLogInBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LogIn.newInstance] factory method to
 * create an instance of this fragment.
 */
class LogIn : Fragment() {

    val database: BuildData by lazy{
        BuildData.getDatabase(requireContext())
    }
    lateinit var repoUser: RepoUser
    lateinit var binding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLogInBinding.inflate(inflater,container,false)
        val view = binding.root
        repoUser= RepoUser(database.dao())
        binding.btLogIn.setOnClickListener{
            buttonLogIn()
        }
        binding.btSignUp.setOnClickListener{
            findNavController().navigate(R.id.signUp)
        }
        binding.ForgetPassword.setOnClickListener{
            findNavController().navigate(R.id.forgetPassword)
        }


        return view
    }

    private fun buttonLogIn() {
        if (binding.edName.text.toString() == repoUser.getName(binding.edName.text.toString())) {
            if (binding.edPassword.text.toString() == repoUser.getPassword(binding.edName.text.toString())) {
                Toast.makeText(requireContext(), "Log in", Toast.LENGTH_SHORT).show()
                val bundle=Bundle()
                bundle.putString("mohamed",binding.edName.text.toString())
                val displayAll=DisplayAll()
                displayAll.arguments=bundle
                findNavController().navigate(R.id.displayAll)

            } else {
                Snackbar.make(binding.btLogIn, "Password is wrong ", Snackbar.LENGTH_SHORT).show()
                binding.edPassword.setError("Password wrong")
            }
        } else {
            Snackbar.make(binding.btLogIn, "Name is wrong ", Snackbar.LENGTH_SHORT).show()
            binding.edName.setError("Name wrong")
        }
    }


}