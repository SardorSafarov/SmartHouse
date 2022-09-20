package com.example.zamin.smarthouse.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zamin.smarthouse.R
import com.example.zamin.smarthouse.app.statusBarColor
import com.example.zamin.smarthouse.databinding.ActivityElectorBinding

class ElectorActivity : AppCompatActivity() {
    lateinit var binding: ActivityElectorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColor(window,getString(R.string.statusbar_color))
    }
}