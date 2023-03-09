package com.example.apitest.UserInterface

import com.example.apitest.Models.UserResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL="https://jsonplaceholder.typicode.com/"


interface UserInterface {
    @GET("users")
    fun getUsers(): Call<UserResponse>
}

object UserService{
    val userInstance: UserInterface
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userInstance=retrofit.create(UserInterface::class.java)
    }
}