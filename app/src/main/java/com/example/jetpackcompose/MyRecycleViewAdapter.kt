package com.example.jetpackcompose

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecycleViewAdapter(private val fruitList: List<Fruit>, private val clickListener: (Fruit) -> Unit) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.bind(fruit, clickListener)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

}

class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {
        val textview: TextView = view.findViewById(R.id.tvName)
        textview.text = fruit.name

        view.setOnClickListener {
            clickListener(fruit)
        }
    }
}

