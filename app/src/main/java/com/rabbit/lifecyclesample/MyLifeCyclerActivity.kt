package com.rabbit.lifecyclesample

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class MyLifeCyclerActivity : Activity(), LifecycleOwner {
    val TAG = "LifeCyclerActivityLOG"
    private lateinit var myLocationListener: MyLocationListener
    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_life)
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)

        myLocationListener = MyLocationListener(this, lifecycle) { location ->
            // update UI
        }
        lifecycle.addObserver(myLocationListener)
    }

    public override fun onStart() {
        super.onStart()
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun onStop() {
        super.onStop()
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    override fun onResume() {
        super.onResume()
        myLocationListener.enable()
    }
}
