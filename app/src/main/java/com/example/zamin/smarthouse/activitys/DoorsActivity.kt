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
    var door = true
    var doortime = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        doorsOn()
    }

    private fun doorsOn() {
        binding.apply {
            btnDoor1.setOnClickListener {
                door = checkTimeDoor()
                if (door) {
                  doorDialog1()
                } else {
                     toastShort(applicationContext,"Sabr")
                }
            }
            btnDoor2.setOnClickListener {
                door = checkTimeDoor()
                if (door) {
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
                toastShort(applicationContext, "1-Eshik ochilmoqda!")
                sendSms("8g335fe2")
                door = false
            }
            setNegativeButton("Ortga"){ dialogInterface: DialogInterface, i: Int ->
                    toastLong(applicationContext,"1-Eshik ochiq qolib ketishi mumkin!")
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
                toastShort(applicationContext, "2-Eshik ochilmoqda!")
                sendSms("77tw4f0g")
                door = false
            }
            setNegativeButton("Ortga"){ dialogInterface: DialogInterface, i: Int ->
                toastLong(applicationContext,"2-Eshik ochiq qolib ketishi mumkin!")
            }
            alertDialog.show()
        }
    }
    private fun checkTimeDoor(): Boolean {
        if (doortime) {
            object : CountDownTimer(10_000, 10_000) {
                override fun onTick(p0: Long) {
                }

                override fun onFinish() {
                    door = true
                    doortime = true
                }
            }.start()
            doortime = false
        }
        return door
    }


    fun sendSms(sms: String) {
        val smsManager: SmsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(sharedPeriferensHelper.getPhoneNumber(), null, sms, null, null)
    }

}