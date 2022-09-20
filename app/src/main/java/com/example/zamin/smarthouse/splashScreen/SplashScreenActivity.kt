package com.example.zamin.smarthouse.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.zamin.smarthouse.MainActivity
import com.example.zamin.smarthouse.databinding.ActivitySplashScreenBinding
import com.example.zamin.smarthouse.utils.statusBarColor

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColor(window,"#3daafc")
        object :CountDownTimer(3500,3500){
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                startActivity(Intent(this@SplashScreenActivity,MainActivity::class.java))
                finish()
            }
        }.start()
    }
}