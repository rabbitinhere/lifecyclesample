package com.rabbit.lifecyclesample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivityLOG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_lifecycler.setOnClickListener {
            startActivity(Intent(this, LifeCyclerActivity::class.java))
        }

        btn_lifecycler_my.setOnClickListener {
            startActivity(Intent(this, MyLifeCyclerActivity::class.java))
        }

    }
}
