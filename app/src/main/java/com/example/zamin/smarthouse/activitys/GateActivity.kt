package com.example.zamin.smarthouse.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.CompoundButton
import com.example.zamin.smarthouse.databinding.ActivityGateBinding
import com.example.zamin.smarthouse.local.SharedPeriferensHelper

class GateActivity : AppCompatActivity() {
    private val sharedPeriferensHelper: SharedPeriferensHelper by lazy { SharedPeriferensHelper(this) }
    lateinit var binding: ActivityGateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gateOnOff()
    }

    private fun gateOnOff() {
        binding.switchGate.setOnCheckedChangeListener({ compoundButton: CompoundButton, b: Boolean ->
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