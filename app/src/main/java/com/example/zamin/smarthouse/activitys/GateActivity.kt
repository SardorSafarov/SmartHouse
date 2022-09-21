package com.example.zamin.smarthouse.activitys

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.telephony.SmsManager
import com.example.zamin.smarthouse.app.toast
import com.example.zamin.smarthouse.app.vibirator
import com.example.zamin.smarthouse.databinding.ActivityGateBinding
import com.example.zamin.smarthouse.local.SharedPeriferensHelper

class GateActivity : AppCompatActivity() {
    private val sharedPeriferensHelper: SharedPeriferensHelper by lazy { SharedPeriferensHelper(this) }
    lateinit var binding: ActivityGateBinding
    var time = true
    var gateTime = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gateOnOff()
    }

    private fun gateOnOff() {
        binding.apply {
            btnGateOpen.setOnLongClickListener {
                time = checkTime()
                if (time) {
                    vibirator(applicationContext)
                    btnGateOpen.isLongClickable = false
                    btnGateOff.isLongClickable = true
                    toast(applicationContext, "Darvoza ochilmoqda!")
                    sendSms("X26e4a7h")
                    time = false
                } else {
                    toast(applicationContext, "Sabr")
                }
                false
            }
            btnGateOff.setOnLongClickListener {
                time = checkTime()
                if (time) {
                    vibirator(applicationContext)
                    btnGateOff.isLongClickable = false
                    btnGateOpen.isLongClickable = true
                    toast(applicationContext, "Darvoza yopilmoqda!")
                    sendSms("7t1fa75u")
                    time = false
                } else {
                    toast(applicationContext, "Sabr")
                }
                false
            }
        }
    }

    private fun checkTime(): Boolean {
        if (gateTime){
        object : CountDownTimer(10_000, 10_000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                time = true
                gateTime = true
            }
        }.start()
        gateTime = false
        }
        return time
    }


    fun sendSms(sms: String) {
        val smsManager: SmsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(sharedPeriferensHelper.getPhoneNumber(), null, sms, null, null)
    }

}