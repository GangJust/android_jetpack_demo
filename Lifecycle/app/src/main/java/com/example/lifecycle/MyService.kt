package com.example.lifecycle

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleService

class MyService : LifecycleService() {
    override fun onCreate() {
        super.onCreate()
        lifecycle.addObserver(MyLifecycleServiceObserver())
    }
}

class MyLifecycleServiceObserver : DefaultLifecycleObserver {
    private val TAG: String = "GLog_Service"

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(TAG, "onCreate, currentState = ${owner.lifecycle.currentState}")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(TAG, "onStart, currentState = ${owner.lifecycle.currentState}")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(TAG, "onResume, currentState = ${owner.lifecycle.currentState}")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(TAG, "onPause, currentState = ${owner.lifecycle.currentState}")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(TAG, "onStop, currentState = ${owner.lifecycle.currentState}")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(TAG, "onDestroy, currentState = ${owner.lifecycle.currentState}")
    }
}