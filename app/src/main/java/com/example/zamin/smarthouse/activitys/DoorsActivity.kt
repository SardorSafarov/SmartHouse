package com.example.zamin.smarthouse.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zamin.smarthouse.databinding.ActivityDoorsBinding

class DoorsActivity : AppCompatActivity() {
    lateinit var binding:ActivityDoorsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}