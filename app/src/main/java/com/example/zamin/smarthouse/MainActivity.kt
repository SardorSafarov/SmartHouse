package com.example.zamin.smarthouse

import android.Manifest.permission.*
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.zamin.smarthouse.activitys.DoorsActivity
import com.example.zamin.smarthouse.activitys.ElectorActivity
import com.example.zamin.smarthouse.activitys.GateActivity
import com.example.zamin.smarthouse.activitys.SettingsActivity
import com.example.zamin.smarthouse.app.d
import com.example.zamin.smarthouse.app.statusBarColor
import com.example.zamin.smarthouse.databinding.ActivityMainBinding
import com.example.zamin.smarthouse.databinding.DialogChangePhoneNumberBinding
import com.example.zamin.smarthouse.local.SharedPeriferensHelper


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val sharedPeriferensHelper: SharedPeriferensHelper by lazy { SharedPeriferensHelper(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkSendMessagePerimetion()
        changePhoneNumber()
        btnSetOnClick()

    }



    private fun btnSetOnClick() {
        binding.apply {
            btnElector.setOnClickListener {
                if (checkPhone())
                startActivity(Intent(this@MainActivity, ElectorActivity::class.java))
            }
            btnDoors.setOnClickListener {
                if (checkPhone())
                startActivity(Intent(this@MainActivity, DoorsActivity::class.java))
            }
            btnGate.setOnClickListener {
                if (checkPhone())
                startActivity(Intent(this@MainActivity, GateActivity::class.java))
            }
            btnSettings.setOnClickListener {
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
            }
        }
    }

    private fun checkPhone():Boolean {
        if(sharedPeriferensHelper.getPhoneNumber()=="empty")
        {
            Toast.makeText(this, "Uy ma'lumotlarini kiriting!!", Toast.LENGTH_SHORT).show()
            return false
        }else{
            return true
        }
    }

    private fun changePhoneNumber() {
        binding.changePhoneNumber.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            val view = LayoutInflater.from(this).inflate(R.layout.dialog_change_phone_number, null)
            val dialogView = DialogChangePhoneNumberBinding.bind(view)
            alertDialog.setView(view)
            val dialog = alertDialog.create()
            dialog.show()
            dialogView.apply {
                btnDialogOk.setOnClickListener {
                    if (phoneNumber.text!!.isNotEmpty()) {
                        if (phoneNumber.text.toString().length > 8) {
                            sharedPeriferensHelper.setPhoneNumber(phoneNumber.text.toString())
                            Toast.makeText(this@MainActivity, "Raqam kiritildi!", Toast.LENGTH_SHORT).show()
                        } else
                            Toast.makeText(this@MainActivity,
                                "Raqam xato kiritildi!",
                                Toast.LENGTH_SHORT).show()
                    } else
                        Toast.makeText(this@MainActivity,
                            "Raqam kiritlmadi!",
                            Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                btnDialogNo.setOnClickListener {
                    dialog.dismiss()
                }
            }


        }
    }

    private fun checkSendMessagePerimetion() {
        if (ContextCompat.checkSelfPermission(this,
                READ_CONTACTS) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this,
                arrayOf(SEND_SMS),
                123)
        } else {
            Toast.makeText(this,
                "Milliy House ilovasiga sms jo`natishga ruxsat bermadinggiz!!",
                Toast.LENGTH_SHORT).show()
        }
    }
}