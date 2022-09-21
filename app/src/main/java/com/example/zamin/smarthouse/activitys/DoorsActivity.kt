package com.example.zamin.smarthouse.activitys

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.telephony.SmsManager
import androidx.appcompat.app.AlertDialog
import com.example.zamin.smarthouse.R
import com.example.zamin.smarthouse.app.toastLong
import com.example.zamin.smarthouse.app.toastShort
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
            btnDoor1.setOnClickListener {
                door1 = checkTimeDoor1()
                if (door1) {
                  doorDialog1()
                } else {
                     toastShort(applicationContext,"Sabr")
                }
            }
            btnDoor2.setOnClickListener {
                door2 = checkTimeDoor2()
                if (door2) {
                    doorDialog2()
                }else
                {
                    toastShort(applicationContext,"Sabr")
                }
            }
        }
    }

    private fun doorDialog1() {
        val alertDialog = AlertDialog.Builder(this, R.style.CustomAlertDialog)
        alertDialog.apply {
            setTitle("Siz haqiqatdan ham 1-eshik oldidamisiz?")

            setPositiveButton("Ochish"){ dialogInterface: DialogInterface, i: Int ->
                vibirator(applicationContext)
                toastShort(applicationContext, "Eshik ochilmoqda!")
                sendSms("8g335fe2")
                door1 = false
            }
            setNegativeButton("Ortga"){ dialogInterface: DialogInterface, i: Int ->
                    toastLong(applicationContext,"Eshik ochiq qolib ketishi mumkin!")
            }
            alertDialog.show()
        }
    }

    private fun doorDialog2() {
        val alertDialog = AlertDialog.Builder(this, R.style.CustomAlertDialog)
        alertDialog.apply {
            setTitle("Siz haqiqatdan ham 2-eshik oldidamisiz?")
            setPositiveButton("Ochish"){ dialogInterface: DialogInterface, i: Int ->
                vibirator(applicationContext)
                toastShort(applicationContext, "Eshik ochilmoqda!")
                sendSms("77tw4f0g")
                door2 = false
            }
            setNegativeButton("Ortga"){ dialogInterface: DialogInterface, i: Int ->
                toastLong(applicationContext,"Eshik ochiq qolib ketishi mumkin!")
            }
            alertDialog.show()
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