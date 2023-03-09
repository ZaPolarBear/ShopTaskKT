package com.example.shoptaskkt.data.repository

import com.example.shoptaskkt.domain.models.UserModel
import com.example.shoptaskkt.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    override fun saveUserData(userModel: UserModel): Boolean{

        return true
    }

    override fun getUserData(): UserModel{
        return UserModel(email = "tesmail@mail.ru", firstName = "FirstTest", lastName = "LastTest", password = "********")
    }
}