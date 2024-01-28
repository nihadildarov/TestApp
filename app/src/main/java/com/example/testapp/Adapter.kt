package com.example.testapp

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.testapp.databinding.ItemBinding

class Adapter (val txtList:List<String>):RecyclerView.Adapter<Adapter.AdapterViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater,parent,false)
        return AdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return txtList.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val currentTxt = txtList[position]
        holder.bind(currentTxt)
    }
    inner class AdapterViewHolder(private val binding:ItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(txt:String){

        }
    }
}