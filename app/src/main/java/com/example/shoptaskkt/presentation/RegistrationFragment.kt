package com.example.shoptaskkt.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.shoptaskkt.R
import com.example.shoptaskkt.presentation.viewmodels.RegistrationViewModel
import com.example.shoptaskkt.presentation.viewmodels.RegistrationViewModelFactory

class RegistrationFragment : Fragment() {


    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, RegistrationViewModelFactory()).get(RegistrationViewModel::class.java)

        val logIn = view?.findViewById<TextView>(R.id.log_in)
        val email = view?.findViewById<EditText>(R.id.email)
        val firstName = view?.findViewById<EditText>(R.id.first_name)
        val lastName = view?.findViewById<EditText>(R.id.last_name)
        val password = view?.findViewById<EditText>(R.id.password)
        val registerBtn = view?.findViewById<Button>(R.id.sing_in_btn)
        val error = view?.findViewById<TextView>(R.id.error_mail)
        logIn?.setOnClickListener {

        }

        registerBtn?.setOnClickListener{
            if(viewModel.checkMail(email = email?.text.toString())) {
                viewModel.save(
                    firstName = firstName?.text.toString(),
                    lastName = lastName?.text.toString(),
                    password = password?.text.toString(),
                    email = email?.text.toString()
                )
                viewModel.openFragment(ProfileFragment(), activity = activity!!)
            }
            else {
                error?.visibility = View.VISIBLE
            }
        }
    }

}