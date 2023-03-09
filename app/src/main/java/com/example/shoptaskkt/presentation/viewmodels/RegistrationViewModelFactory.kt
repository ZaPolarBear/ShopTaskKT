package com.example.shoptaskkt.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoptaskkt.data.repository.UserRepositoryImpl
import com.example.shoptaskkt.domain.repository.UserRepository
import com.example.shoptaskkt.domain.usecase.SaveUserUseCase

class RegistrationViewModelFactory: ViewModelProvider.Factory {

    private val userRepository: UserRepository = UserRepositoryImpl()

    private val saveUserUseCase: SaveUserUseCase = SaveUserUseCase(userRepository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegistrationViewModel(userRepository = userRepository, saveUserUseCase = saveUserUseCase) as T
    }
}