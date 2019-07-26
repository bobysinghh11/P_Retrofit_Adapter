package com.stuffshuf.p_retrofit_adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_list.view.*

class UsersAdapter(val context: Context,val user:ArrayList<Users>):RecyclerView.Adapter<UsersAdapter.UsersAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapterViewHolder {
  val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.user_list, parent, false)
        return UsersAdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: UsersAdapterViewHolder, position: Int) {
       val userdata=user[position]
        holder.bind(userdata)

    }


    class UsersAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

        fun bind(users: Users)
        {
            with(itemView)
            {


               tvID.text=users.id.toString()
                tvNAME.text=users.name
                tvUSER.text=users.username
                tvEMAIL.text=users.email
                tvADRESS.text=users.address.toString()


            }
        }
    }
}