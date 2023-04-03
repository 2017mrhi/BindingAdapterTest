package com.mrhi2023.bindingadaptertest

import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.invoke.MutableCallSite

class MyViewModel : ViewModel() {

    val item: MutableLiveData<Item> by lazy { MutableLiveData<Item>() }
    fun changeItem(){
        item.postValue(Item("Good", "https://cdn.pixabay.com/photo/2016/11/08/05/26/woman-1807533_960_720.jpg"))
    }


    val name: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    fun changeName(){
        name.value= "robin"
    }


    val items: MutableLiveData<MutableList<Item>> by lazy { MutableLiveData<MutableList<Item>>() }
    fun loadItems(){
        //원래는 레트로핏 작업..
        items.value= items.value ?: mutableListOf(
            Item("sam","https://cdn.pixabay.com/photo/2016/07/11/15/43/woman-1509956_960_720.jpg"),
            Item("robin","https://cdn.pixabay.com/photo/2016/11/08/05/26/woman-1807533_960_720.jpg"),
            Item("park","")
        )
    }
    fun addItem(){
        val list= items.value
        list?.add(0,Item("NEW","https://cdn.pixabay.com/photo/2015/05/28/22/29/bicycle-788733_960_720.jpg"))
        items.value= list
    }


    fun clickedItemView(item: Item){
        name.value= "clicked ${item.title}"
    }


}