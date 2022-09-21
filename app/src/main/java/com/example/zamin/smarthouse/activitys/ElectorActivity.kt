package com.example.zamin.smarthouse.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.example.zamin.smarthouse.R
import com.example.zamin.smarthouse.app.d
import com.example.zamin.smarthouse.app.statusBarColor
import com.example.zamin.smarthouse.databinding.ActivityElectorBinding

class ElectorActivity : AppCompatActivity() {
    lateinit var binding: ActivityElectorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        elctorOnOff()
    }

    private fun elctorOnOff() {
        binding.switchElector.setOnCheckedChangeListener({ compoundButton: CompoundButton, b: Boolean ->
            when(b){
                true->{
                    Toast.makeText(this, "yondi", Toast.LENGTH_SHORT).show()
                }
                else->{
                    Toast.makeText(this, "O`chdi", Toast.LENGTH_SHORT).show()
                }
            }
        })

        
    }
}