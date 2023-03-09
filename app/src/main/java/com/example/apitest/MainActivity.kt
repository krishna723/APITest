package com.example.apitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apitest.Models.UserResponse
import com.example.apitest.UserInterface.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var newAdapter:newAdapte
    lateinit var adapter:UserAdapter
    var rvUser: RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvUser=findViewById(R.id.rvUser)

//        val user= arrayListOf<String>()
//        user.add("Krishna Das")
//        user.add("Hari Das")

//        adapter= UserAdapter(this,user)
//        rvUser?.adapter=adapter
//        rvUser?.layoutManager=LinearLayoutManager(this)
//        newAdapter= newAdapte(this,user)
//        rvUser?.adapter=newAdapter
//        rvUser?.layoutManager=LinearLayoutManager(this)
        getUser()
    }

    private fun getUser() {
        val userList: Call<UserResponse> = UserService.userInstance.getUsers()

        userList.enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val users=response.body()
                if (users != null){
                    adapter= UserAdapter(this@MainActivity,users)
                    rvUser?.adapter=adapter
                    rvUser?.layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.message?.let { Log.d("Error2", it) }
            }

        })

    }
}