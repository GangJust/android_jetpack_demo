package com.example.lifecycle

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*

class MainActivity2 : Activity(), LifecycleOwner {
    private val registry: LifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        registry.addObserver(MainActivity2Observer())
    }

    override fun getLifecycle(): Lifecycle {
        return registry
    }
}

class MainActivity2Observer : DefaultLifecycleObserver {
    private val TAG = "MainActivity2Observer"

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(TAG, "onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(TAG, "onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(TAG, "onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(TAG, "onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(TAG, "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(TAG, "onDestroy")
    }
}