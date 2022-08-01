package com.example.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databinding.bean.User
import com.example.databinding.databinding.ActivityMainBinding
import com.example.databinding.event.MainEventPresenter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            user = User("张三", 18, true)
            presenter = MainEventPresenter()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}