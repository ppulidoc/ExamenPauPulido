package com.paudam.examenpaupulido.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.paudam.examenpaupulido.R
import com.paudam.practicaalumnesrepastotal.data.Producte


class ProductesAdapter (private val mList: List<Producte>) : RecyclerView.Adapter<ProductesAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_producte, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val producte = mList[position]


        holder.textViewNom.text = producte.nom
        holder.textViewPreu.text = producte.preu.toString()


        holder.layoutRecycler.setOnClickListener { view ->


        }

    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewPreu: TextView = itemView.findViewById(R.id.textViewPreu)
        val textViewNom: TextView = itemView.findViewById(R.id.textViewNom)
        val layoutRecycler: LinearLayout = itemView.findViewById(R.id.linearId)
    }
}