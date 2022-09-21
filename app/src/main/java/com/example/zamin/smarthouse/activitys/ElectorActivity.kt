package com.example.zamin.smarthouse.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.CompoundButton
import android.widget.Toast
import com.example.zamin.smarthouse.R
import com.example.zamin.smarthouse.app.d
import com.example.zamin.smarthouse.app.statusBarColor
import com.example.zamin.smarthouse.databinding.ActivityElectorBinding
import com.example.zamin.smarthouse.local.SharedPeriferensHelper

class ElectorActivity : AppCompatActivity() {
    private val sharedPeriferensHelper:SharedPeriferensHelper by lazy { SharedPeriferensHelper(this) }
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
                   // sendSms("code")
                }
                else->{
                  //  sendSms("code")
                }
            }
        })

        
    }
    fun sendSms(sms:String){
        val smsManager: SmsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(sharedPeriferensHelper.getPhoneNumber(), null, sms, null, null)
    }
}