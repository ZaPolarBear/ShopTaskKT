package com.example.shoptaskkt.domain.usecase

import com.example.shoptaskkt.domain.models.UserModel
import com.example.shoptaskkt.domain.repository.UserRepository

class SaveUserUseCase(private val userRepository: UserRepository) {

    fun execute(userModel: UserModel){
        userRepository.saveUserData(userModel)
    }
}