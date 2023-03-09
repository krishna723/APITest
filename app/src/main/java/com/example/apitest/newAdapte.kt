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

class newAdapte(val context: Context, val userList: ArrayList<String>):RecyclerView.Adapter<newAdapte.userViewHolder>(){


    class userViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var userName=itemView.findViewById<TextView>(R.id.tvText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.rv_item,parent,false)
        return userViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        val users=userList[position]
        holder.userName.text=users
    }
}