package com.example.zamin.smarthouse.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.telephony.SmsManager
import com.example.zamin.smarthouse.app.toastShort
import com.example.zamin.smarthouse.app.vibirator
import com.example.zamin.smarthouse.databinding.ActivityElectorBinding
import com.example.zamin.smarthouse.local.SharedPeriferensHelper

class ElectorActivity : AppCompatActivity() {
    private val sharedPeriferensHelper: SharedPeriferensHelper by lazy { SharedPeriferensHelper(this) }
    lateinit var binding: ActivityElectorBinding
    var time = true
    var electorTime = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        elctorOnOff()
    }

    private fun elctorOnOff() {
        binding.apply {
            btnElectorOn.setOnLongClickListener {
                time = checkTime()
                if (time) {
                    vibirator(applicationContext)
                    btnElectorOn.isLongClickable = false
                    btnElectorOff.isLongClickable = true
                    sendSms("Yc4fw6f3")
                    toastShort(applicationContext, "Elektr yonmoqda!")
                    time = false
                } else {
                    toastShort(applicationContext, "Sabr")
                }
                false
            }
            btnElectorOff.setOnLongClickListener {
                time = checkTime()
                if (time) {
                    vibirator(applicationContext)
                    btnElectorOn.isLongClickable = true
                    btnElectorOff.isLongClickable = false
                    sendSms("8g6r2g59")
                    toastShort(applicationContext, "Elektr o'chmoqda!")
                    time = false
                } else {
                    toastShort(applicationContext, "Sabr")
                }
                false
            }
        }
    }
    private fun checkTime(): Boolean {
        if (electorTime){
        object : CountDownTimer(10_000, 10_000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                time = true
                electorTime = true
            }
        }.start()
        electorTime = false
        }
        return time
    }

    fun sendSms(sms: String) {
        val smsManager: SmsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(sharedPeriferensHelper.getPhoneNumber(), null, sms, null, null)
    }
}