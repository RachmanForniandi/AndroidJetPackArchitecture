package com.example.basicrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_data.view.*

class SimpleAdapter (private val listBuah:List<FruitDealer>,private val clickListener:(FruitDealer)->Unit) : RecyclerView.Adapter<DealerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealerHolder {
        val listData = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        return DealerHolder(listData)
    }

    override fun getItemCount(): Int {
        return listBuah.size
    }

    override fun onBindViewHolder(holder: DealerHolder, position: Int) {

        holder.bind(listBuah[position],clickListener)
    }
}

class DealerHolder(val view : View) : RecyclerView.ViewHolder(view) {
    fun bind(fruitDealer: FruitDealer, clickListener: (FruitDealer) -> Unit) {
        view.tv_name.text =fruitDealer.name
        view.setOnClickListener {
            clickListener(fruitDealer)
        }
    }



}


