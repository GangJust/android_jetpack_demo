package com.example.vl

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.vl.databinding.ActivityMainBinding
import com.example.vl.model.MainVM
import com.example.vl.utils.ColorUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //private val mainVm: MainVM by viewModels()
    private lateinit var mainVm: MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //mainVm = ViewModelProvider(MainActivity@ this).get(MainVM::class.java)
        mainVm = ViewModelProvider(
            MainActivity@ this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainVM::class.java)

        mainVm.count.observe(MainActivity@ this) {
            binding.myTextView.text = "$it"
        }

        binding.add.setOnClickListener {
            mainVm.count.value = (mainVm.count.value ?: 0) + 1
        }

        binding.toSecond.setOnClickListener {
            startActivity(Intent(MainActivity@ this, SecondActivity::class.java))
        }

        binding.toThree.setOnClickListener {
            startActivity(Intent(MainActivity@ this, ThreeActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        //binding.root.setBackgroundColor(ColorUtil.randomColor())
    }
}