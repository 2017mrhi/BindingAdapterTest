package com.mrhi2023.bindingadaptertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mrhi2023.bindingadaptertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.item= Item("Helo", "https://cdn.pixabay.com/photo/2016/07/11/15/43/woman-1509956_960_720.jpg")

        val vm:MyViewModel= ViewModelProvider(this).get(MyViewModel::class.java)
        vm.item.value= vm.item.value ?: Item("Helo", "https://cdn.pixabay.com/photo/2016/07/11/15/43/woman-1509956_960_720.jpg")
        vm.name.value= vm.name.value ?: "sam"
        vm.loadItems()
        //vm.item.set(Item("Helo", "https://cdn.pixabay.com/photo/2016/07/11/15/43/woman-1509956_960_720.jpg"))

        binding.lifecycleOwner=this // 액티비티나. 프레그먼트가 활성화 되어 있을때만 UI갱신이 이루어지도록...라이프사이클 오너를 지정
        binding.vm= vm

        //binding.btn.setOnClickListener { vm.item.set(Item("Nice","https://cdn.pixabay.com/photo/2016/11/08/05/26/woman-1807533_960_720.jpg")) }
        //binding.btn.setOnClickListener { vm.item.postValue(Item("Nice","https://cdn.pixabay.com/photo/2016/11/08/05/26/woman-1807533_960_720.jpg")) }


    }
}