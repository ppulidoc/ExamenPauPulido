package com.paudam.examenpaupulido.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.model.User
class UserAdapter(
    private var usersList: MutableList<User>,
    private val itemClickListener: (User) -> Unit 
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNom: TextView = view.findViewById(R.id.textViewUserName)
        val textViewEmail: TextView = view.findViewById(R.id.textViewUserEmail)
        val textViewAge: TextView = view.findViewById(R.id.textViewUserAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_cardview, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = usersList[position]
        holder.textViewNom.text = user.name
        holder.textViewEmail.text = user.email
        holder.textViewAge.text = user.age.toString()

        // Detectar clic en el item y pasar los datos
        holder.itemView.setOnClickListener {
            itemClickListener(user)
        }
    }

    override fun getItemCount(): Int = usersList.size

    fun updateList(newList: List<User>) {
        usersList.clear()
        usersList.addAll(newList)
        notifyDataSetChanged() // Notifica al RecyclerView que los datos han cambiado
    }
}

