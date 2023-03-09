package com.example.shoptaskkt.presentation.viewmodels

import android.util.Patterns
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.example.shoptaskkt.R
import com.example.shoptaskkt.domain.models.UserModel
import com.example.shoptaskkt.domain.repository.UserRepository
import com.example.shoptaskkt.domain.usecase.SaveUserUseCase

class RegistrationViewModel(private val userRepository: UserRepository, private val saveUserUseCase: SaveUserUseCase) : ViewModel() {


    fun save(firstName: String, lastName: String, password: String, email: String) {
        val userModel = UserModel(firstName = firstName, lastName = lastName, password = password, email = email)

        saveUserUseCase.execute(userModel)
    }

    fun checkMail(email: String): Boolean{

        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun openFragment(fragment: Fragment, activity: FragmentActivity){
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }
}