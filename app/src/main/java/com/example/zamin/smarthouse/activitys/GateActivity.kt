package com.example.zamin.smarthouse.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zamin.smarthouse.databinding.ActivityGateBinding

class GateActivity : AppCompatActivity() {
    lateinit var binding: ActivityGateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGateBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}