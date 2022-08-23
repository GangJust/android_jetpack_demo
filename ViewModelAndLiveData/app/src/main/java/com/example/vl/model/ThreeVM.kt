package com.example.vl.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.vl.bean.User

class ThreeVM(user: User) : ViewModel() {
    private val _userObs: MutableLiveData<User> = MutableLiveData(user)

    val userObs: LiveData<User> = _userObs //转为不可修改父类

    val userName: LiveData<String> = Transformations.map(_userObs) { it.name }

    val userAge: LiveData<Int> = Transformations.map(_userObs) { it.age }

    fun setName(name: String) {
        _userObs.value = _userObs.value?.copy(name = name)
    }

    fun setAge(age: Int) {
        _userObs.value = _userObs.value?.copy(age = age)
    }

    fun setUser(user: User) {
        _userObs.value = user
    }
}

