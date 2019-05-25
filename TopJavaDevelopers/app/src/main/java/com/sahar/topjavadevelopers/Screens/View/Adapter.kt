package com.sahar.topjavadevelopers.Screens.View

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sahar.topjavadevelopers.Model.User
import com.sahar.topjavadevelopers.R

class Adapter(val users : ArrayList<User>) : androidx.recyclerview.widget.RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Adapter.ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.cardview,p0,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: Adapter.ViewHolder, p1: Int) {
        viewHolder.bindItems(users[p1])
    }

    override fun getItemCount(): Int {
        println("usersize:"+users.size)
        return users.size
    }

    class ViewHolder (itemView:View): androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){
        fun bindItems(user:User){
            println(user.login)
            var nameTV = itemView.findViewById<TextView>(R.id.nameTV)
            nameTV.text = user.login
        }
    }
}