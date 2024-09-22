package com.example.myapplaunchweather.domain.repository

import com.example.myapplaunchweather.data.local.User
import com.example.myapplaunchweather.data.local.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val dao: UserDao) {

    fun getAllUsers(): List<User> {
        return dao.getAllUsers()
    }

    suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            dao.insertUser(user)
        }
    }

    suspend fun deleteUser(userId: Long) {
        withContext(Dispatchers.IO) {
            dao.deleteUserById(userId)
        }
    }
}