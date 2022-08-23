package com.example.vl.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainVM : ViewModel() {
    var count: MutableLiveData<Int> = MutableLiveData()
}