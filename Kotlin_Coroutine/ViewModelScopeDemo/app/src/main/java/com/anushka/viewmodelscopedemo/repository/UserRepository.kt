package com.anushka.viewmodelscopedemo.repository

import com.anushka.viewmodelscopedemo.model.User
import kotlinx.coroutines.delay

class UserRepository {

    suspend fun  getUser():List<User>{
        delay(8000)
        val users : List<User> = listOf(
            User(1,"Zero"),
            User(2,"Seven"),
            User(3,"Leo"),
            User(4,"Taro"),
            User(5,"Ace"),
            User(6,"Tiga"),
            User(7,"Dyna")
        )
        return users
    }
}