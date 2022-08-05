package com.example.observable.bean

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

data class User(
    var name: ObservableField<String>,
    var age: ObservableInt,
    var member: ObservableBoolean
)
