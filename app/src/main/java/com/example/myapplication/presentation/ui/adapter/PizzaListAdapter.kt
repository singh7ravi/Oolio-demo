package com.example.myapplication.presentation.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.ui.listeners.OnListItemCliclkListener
import com.example.myapplication.presentation.ui.model.ListItem

class PizzaListAdapter (private val items: List<ListItem>) :
    RecyclerView.Adapter<PizzaListAdapter.CustomItemViewHolder>() {

    private var onClickListener: OnListItemCliclkListener? = null

    class CustomItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.pizzaImg)
        val itemName: TextView = itemView.findViewById(R.id.pizzaType)
        val itemShortDesc: TextView = itemView.findViewById(R.id.pJobProfiletxt)
        val itemPrice: TextView = itemView.findViewById(R.id.pricetxt)
        val rowItem: ConstraintLayout = itemView.findViewById(R.id.rowCl)
    }

    fun setOnClickListener(onClickListener: OnListItemCliclkListener) {
        this.onClickListener = onClickListener
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
        holder.itemShortDesc.text = item.shortDesc
        holder.itemPrice.text = item.price
        holder.rowItem.setOnClickListener {
            Log.d("+++++++++++++++++", "inside position $position")
            if(onClickListener != null) {
                onClickListener!!.onClickItem(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}