package com.example.zamin.smarthouse.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.telephony.SmsManager
import com.example.zamin.smarthouse.app.d
import com.example.zamin.smarthouse.app.toast
import com.example.zamin.smarthouse.app.vibirator
import com.example.zamin.smarthouse.databinding.ActivityDoorsBinding
import com.example.zamin.smarthouse.local.SharedPeriferensHelper

class DoorsActivity : AppCompatActivity() {
    private val sharedPeriferensHelper: SharedPeriferensHelper by lazy { SharedPeriferensHelper(this) }
    lateinit var binding: ActivityDoorsBinding
    var door1 = true
    var door1time = true
    var door2 = true
    var door2time = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        doorsOn()
    }

    private fun doorsOn() {
        binding.apply {
            btnDoor1.setOnLongClickListener {
                door1 = checkTimeDoor1()
                if (door1) {
                    vibirator(applicationContext)
                    toast(applicationContext, "Eshik ochilmoqda!")
                  //  sendSms("8g335fe2")
                    door1 = false
                } else {
                     toast(applicationContext,"Sabr")
                }
                false
            }
            btnDoor2.setOnLongClickListener {
                door2 = checkTimeDoor2()
                if (door2) {
                    vibirator(applicationContext)
                    toast(applicationContext, "Eshik ochilmoqda!")
                   // sendSms("77tw4f0g")
                    door2 = false
                }else
                {
                    toast(applicationContext,"Sabr")
                }
                false
            }
        }
    }


    private fun checkTimeDoor1(): Boolean {
        if (door1time) {
            object : CountDownTimer(10_000, 10_000) {
                override fun onTick(p0: Long) {
                }

                override fun onFinish() {
                    door1 = true
                    door1time = true
                }
            }.start()
            door1time = false
        }
        return door1
    }

    private fun checkTimeDoor2(): Boolean {
        if (door2time){
        object : CountDownTimer(10_000, 10_000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                door2 = true
                door2time = true
            }
        }.start()
        door2time = false
        }
        return door2
    }

    fun sendSms(sms: String) {
        val smsManager: SmsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(sharedPeriferensHelper.getPhoneNumber(), null, sms, null, null)
    }

}