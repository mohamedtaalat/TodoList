package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todolist.DataUser.BuildData
import com.example.todolist.DataUser.RepoUser
import com.example.todolist.DataUser.User
import com.example.todolist.databinding.FragmentSignUpBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUp.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUp : Fragment() {
   lateinit var binding: FragmentSignUpBinding
    val database: BuildData by lazy{
        BuildData.getDatabase(requireContext())
    }
    lateinit var repoUser: RepoUser
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        repoUser=RepoUser(database.dao())
        binding=FragmentSignUpBinding.inflate(inflater,container,false)
        val view=binding.root
        binding.btSignup2.setOnClickListener{
            signUpButton()
        }
        return view
    }

    private fun signUpButton() {
        if (binding.edName2.text.toString() == repoUser.getName(binding.edName2.text.toString()) || binding.edName2.text == null) {
            Snackbar.make(binding.textView6, "Name unique", Snackbar.LENGTH_SHORT).show()
            binding.edName2.setError("Name required")
        } else {
            if (binding.edPassword2.text.toString().length < 8) {
                Snackbar.make(binding.textView6, "Password 8 digit", Snackbar.LENGTH_SHORT).show()
                binding.edPassword2.setError("8 digit")
            } else {
                val user =
                    User(binding.edName2.text.toString(), binding.edPassword2.text.toString())
                repoUser.addUser(user)
                Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.displayAll)
            }
        }
    }


}