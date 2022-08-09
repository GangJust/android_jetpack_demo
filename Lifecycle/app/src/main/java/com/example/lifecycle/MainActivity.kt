package com.example.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*

class MainActivity : AppCompatActivity() {
    private val mLifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 加入观察者
        //lifecycle.addObserver(MyLifecycleObserver())
        //lifecycle.addObserver(MyLifecycleObserverEvent())
        mLifecycleRegistry.addObserver(MyDefaultLifecycleObserver())

        //val intent = Intent(MainActivity@ this, MyService::class.java)
        //startService(intent)
    }
}

class MyLifecycleObserver : LifecycleObserver {
    private val TAG: String = "GLog"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "onCreate, currentState = ${owner.lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(owner: LifecycleOwner) {
        Log.d(TAG, "onStart, currentState = ${owner.lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, "onResume, currentState = ${owner.lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(owner: LifecycleOwner) {
        Log.d(TAG, "onPause, currentState = ${owner.lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "onStop, currentState = ${owner.lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, "onDestroy, currentState = ${owner.lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner) {
        Log.d(TAG, "onAny, currentState = ${owner.lifecycle.currentState}")
    }
}

class MyLifecycleObserverEvent : LifecycleEventObserver {
    private val TAG: String = "GLogEvent"

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                Log.d(TAG, "ON_CREATE, currentState = ${source.lifecycle.currentState}")
            }
            Lifecycle.Event.ON_START -> {
                Log.d(TAG, "ON_START, currentState = ${source.lifecycle.currentState}")
            }
            Lifecycle.Event.ON_RESUME -> {
                Log.d(TAG, "ON_RESUME, currentState = ${source.lifecycle.currentState}")
            }
            Lifecycle.Event.ON_PAUSE -> {
                Log.d(TAG, "ON_PAUSE, currentState = ${source.lifecycle.currentState}")
            }
            Lifecycle.Event.ON_STOP -> {
                Log.d(TAG, "ON_STOP, currentState = ${source.lifecycle.currentState}")
            }
            Lifecycle.Event.ON_DESTROY -> {
                Log.d(TAG, "ON_DESTROY, currentState = ${source.lifecycle.currentState}")
            }
            Lifecycle.Event.ON_ANY -> {
                Log.d(TAG, "ON_ANY, currentState = ${source.lifecycle.currentState}")
            }
        }
    }

}

class MyDefaultLifecycleObserver : DefaultLifecycleObserver {
    private val TAG: String = "GLogDefault"

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