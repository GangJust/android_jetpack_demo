package com.example.lifecycle

import android.app.Application
import android.util.Log
import androidx.lifecycle.*


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        //ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifecycle())
    }
}

class AppLifecycle : DefaultLifecycleObserver{
    private val TAG: String = "GLog_App"

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
