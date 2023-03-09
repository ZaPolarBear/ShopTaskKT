package com.example.shoptaskkt.domain.repository

import com.example.shoptaskkt.domain.models.UserModel

interface UserRepository {

    fun saveUserData(userModel: UserModel): Boolean

    fun getUserData(): UserModel
}