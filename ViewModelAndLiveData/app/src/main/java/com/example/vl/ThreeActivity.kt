package com.example.vl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vl.bean.User
import com.example.vl.databinding.ActivityThreeBinding
import com.example.vl.model.ThreeVM

class ThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreeBinding
    private lateinit var vm: ThreeVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this, ThreeViewModelFactory(User("张三", 18))).get(ThreeVM::class.java)

        // 观察数据变化
        vm.userName.observe(this) {
            binding.nameText.text = it
        }

        // 点击按钮改变user
        binding.changeName.setOnClickListener {
            // kotlin中的三目运算
            vm.setName(if (vm.userName.value == "李四") "张三" else "李四")
        }
    }
}

/// 自定义 ViewModelFactory
class ThreeViewModelFactory(var user: User) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(User::class.java).newInstance(user)
    }
}