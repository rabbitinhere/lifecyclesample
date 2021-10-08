package com.rabbit.lifecyclesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LifeCyclerActivity : AppCompatActivity() {
    val TAG = "LifeCyclerActivityLOG"
    private lateinit var myLocationListener: MyLocationListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life)
        myLocationListener = MyLocationListener(this, lifecycle) { location ->
            // update UI
        }
        lifecycle.addObserver(myLocationListener)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        myLocationListener.enable()
    }
}
