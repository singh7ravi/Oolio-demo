package com.example.myapplication.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.ui.model.ListItem

class PizzaListAdapter (private val items: List<ListItem>) :
    RecyclerView.Adapter<PizzaListAdapter.CustomItemViewHolder>() {

    class CustomItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        val itemName: TextView = itemView.findViewById(R.id.itemName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return CustomItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomItemViewHolder, position: Int) {
        val item = items[position]
        holder.itemImage.setImageResource(item.imageResId)
        holder.itemName.text = item.name
    }

    override fun getItemCount(): Int {
        return items.size
    }
}