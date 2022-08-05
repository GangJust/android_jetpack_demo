package com.example.observable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.example.observable.bean.ObsUser
import com.example.observable.bean.User
import com.example.observable.databinding.ActivityMainBinding
import com.example.observable.event.MainEventPresenter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            obsUser = ObsUser().apply {
                name = "张三"
                age = 18
                member = false
            }
            presenter = MainEventPresenter();
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}