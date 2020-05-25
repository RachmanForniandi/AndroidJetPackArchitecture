package com.example.learnroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.learnroom.R
import com.example.learnroom.databinding.ListUserDataBinding
import com.example.learnroom.dbModel.Subscriber

class DataAdapter (private val clickListener:(Subscriber)->Unit): RecyclerView.Adapter<DataHolder>() {
    private val subscribersList= ArrayList<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val binding:ListUserDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_user_data,parent,false)
        return DataHolder(binding)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.bind(subscribersList[position],clickListener)
    }

    fun setList(subscribers: List<Subscriber>){
        subscribersList.clear()
        subscribersList.addAll(subscribers)
    }
}

class DataHolder(val binding: ListUserDataBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(subscriber: Subscriber,clickListener:(Subscriber)->Unit) {
        binding.tvName.text = subscriber.name
        binding.tvEmail.text = subscriber.email
        binding.cardData.setOnClickListener {
            clickListener(subscriber)
        }
    }

}
