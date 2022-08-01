package com.example.databinding.event

import android.view.View
import android.widget.Toast
import com.example.databinding.bean.User

class MainEventPresenter {
    fun onClick(view: View) {
        Toast.makeText(view.context, "点击: $view", Toast.LENGTH_LONG).show()
    }

    fun testClick(view: View, user: User) {
        Toast.makeText(view.context, "点击: ${user.name}", Toast.LENGTH_LONG).show()
    }
}