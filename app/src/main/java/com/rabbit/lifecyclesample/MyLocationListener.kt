package com.rabbit.lifecyclesample

import android.app.Activity
import android.content.Context
import android.location.Location
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

internal class MyLocationListener(
    private val context: Context,
    private val lifecycle: Lifecycle,
    private val callback: (Location) -> Unit
): LifecycleObserver {

    private val TAG = "MyLocationListenerLOG"
    private var enabled = false
    companion object{
        var activity: Activity? = null
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (enabled) {
            // connect
            Log.d(TAG, "start enabled")
        }else{
            Log.d(TAG, "start unenabled")
        }
    }

    fun enable() {
        enabled = true
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
            Log.d(TAG, "enable free to go")
        }else{
            Log.d(TAG, "enable not started")
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        Log.d(TAG, "stop")
        // disconnect if connected
    }
}