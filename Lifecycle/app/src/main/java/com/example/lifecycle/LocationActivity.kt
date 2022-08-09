package com.example.lifecycle

import android.content.Context
import android.location.Location
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent


/// 位置监听
class MyLocationListener(
    private val context: Context,
    private val callback: (Location) -> Unit
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun connect() {
        /// todo 开始连接
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun disconnect() {
        /// todo 断开连接
    }
}

class LocationActivity : AppCompatActivity() {
    private lateinit var myLocationListener: MyLocationListener


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        myLocationListener = MyLocationListener(this) { location ->
            /// todo 更新 UI
        }

        // 加入生命周期观察
        lifecycle.addObserver(myLocationListener)
    }
}