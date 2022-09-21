package com.example.zamin.smarthouse.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import com.example.zamin.smarthouse.databinding.ActivityDoorsBinding
import com.example.zamin.smarthouse.local.SharedPeriferensHelper

class DoorsActivity : AppCompatActivity() {
    private val sharedPeriferensHelper:SharedPeriferensHelper by lazy { SharedPeriferensHelper(this) }
    lateinit var binding:ActivityDoorsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        doorsOn()
    }

    private fun doorsOn() {
        binding.apply {
            btnDoor1.setOnClickListener {
              //  sendSms("code")
            }
            btnDoor2.setOnClickListener {
               // sendSms("code")
            }
        }
    }
    fun sendSms(sms:String){
        val smsManager: SmsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(sharedPeriferensHelper.getPhoneNumber(), null, sms, null, null)
    }
}