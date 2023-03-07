package com.example.shoptaskkt.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shoptaskkt.R
import com.example.shoptaskkt.presentation.viewmodels.RegistrationViewModel

class RegistrationFragment : Fragment() {

    private lateinit var logIn: TextView

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
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

        logIn = view!!.findViewById(R.id.log_in)

        logIn.setOnClickListener {
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame, LoginFragment())
            transaction.disallowAddToBackStack()
            transaction.commit()
        }
    }

}