package com.example.zamin.smarthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zamin.smarthouse.utils.statusBarColor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statusBarColor(window,"#3daafc")


    }
}