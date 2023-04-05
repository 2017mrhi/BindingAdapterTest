package com.mrhi2023.bindingadaptertest

import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

object MyBindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view:ImageView, url:String){
        Glide.with(view.context).load(url).error(R.drawable.newyork).into(view)
    }

    @BindingAdapter("itemList")
    @JvmStatic
    fun setItemList(view:RecyclerView, items:MutableList<Item>){
        view.adapter= MyAdapter(view.context, items)
    }

    @BindingAdapter("btnTitle")
    @JvmStatic
    fun setButtonTitle(view:Button, title:String){
        view.text= title
    }
}