package com.example.observable.event

import android.view.View
import com.example.observable.bean.ObsUser

class MainEventPresenter {
    fun onClick(view: View?, user: ObsUser) {
        if(user.name == "张三"){
            user.name = "李三"
            user.age = 23
            user.member = true
        }else{
            user.name = "张三"
            user.age = 18
            user.member = false
        }
    }
}