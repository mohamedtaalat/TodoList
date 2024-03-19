package com.example.todolist

import android.content.Intent
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
import com.example.todolist.databinding.FragmentForgetPasswordBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [forgetPassword.newInstance] factory method to
 * create an instance of this fragment.
 */
class forgetPassword : Fragment() {
   lateinit var binding: FragmentForgetPasswordBinding
    val database: BuildData by lazy{
        BuildData.getDatabase(requireContext())
    }
    lateinit var repoUser: RepoUser
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        repoUser= RepoUser(database.dao())
        binding= FragmentForgetPasswordBinding.inflate(inflater,container,false)
        val view=binding.root
        binding.btLogIn2.setOnClickListener {
            buttonLogIn()
        }
        binding.btContact.setOnClickListener {
            Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()
            val intent= Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }
        return view
    }

    private fun buttonLogIn() {
        if (binding.edName5.text.toString() == repoUser.getName(binding.edName5.text.toString())) {
            if (binding.edpassword5.text.length > 8) {
                var user =
                    User(binding.edName5.text.toString(), binding.edpassword5.text.toString())
                repoUser.updatePassword(user)
                Toast.makeText(requireContext(), "Succesful", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.logIn)
            } else {
                binding.edpassword5.setError("Password > 8 digit")
            }
        } else {
            Snackbar.make(binding.textView15, "Name not exist", Snackbar.LENGTH_SHORT).show()
        }
    }


}