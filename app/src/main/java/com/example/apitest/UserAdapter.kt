package com.example.apitest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apitest.Models.UserResponse
import com.example.apitest.Models.UserResponseItem

class UserAdapter(val context: Context,val userList: List<UserResponseItem>):RecyclerView.Adapter<UserAdapter.userViewHolder>(){


    class userViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var userName=itemView.findViewById<TextView>(R.id.tvUserName)
        var address=itemView.findViewById<TextView>(R.id.tvAddress)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return userViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        val users=userList[position]
        holder.userName.text=users.name
        holder.address.text=users.address.city
    }
}