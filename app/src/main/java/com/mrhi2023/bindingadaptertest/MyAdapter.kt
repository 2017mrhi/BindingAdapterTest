package com.mrhi2023.bindingadaptertest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mrhi2023.bindingadaptertest.databinding.RecyclerItemBinding

class VH(val binding:RecyclerItemBinding) : ViewHolder(binding.root){
    fun bind(item:Item){
        binding.item= item
        binding.vm= ViewModelProvider(binding.iv.context as MainActivity).get(MyViewModel::class.java)
        binding.executePendingBindings()
    }
}

class MyAdapter(var context: Context, var items:MutableList<Item>) : Adapter<VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding= RecyclerItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var item= items[position]
        holder.bind(item)
    }
}