package com.example.vl.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondVM : ViewModel() {
    private var _number: MutableLiveData<Int> = MutableLiveData()
    val number: LiveData<Int> = _number

    fun onIncrease() {
        _number.value = (_number.value ?: 0) + 1
    }

    fun onMinus() {
        _number.value = (_number.value ?: 0) - 1
    }

    override fun onCleared() {
        super.onCleared()

    }
}