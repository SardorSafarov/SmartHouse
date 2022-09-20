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
        statusBarColor(window, getString(R.string.statusbar_color))
        changePhoneNumber()
        btnSetOnClick()
        checkSendMessagePerimetion()
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

    private fun btnSetOnClick() {
        binding.apply {
            btnElector.setOnClickListener {
                startActivity(Intent(this@MainActivity, ElectorActivity::class.java))
            }
            btnDoors.setOnClickListener {
                startActivity(Intent(this@MainActivity, DoorsActivity::class.java))
            }
            btnGate.setOnClickListener {
                startActivity(Intent(this@MainActivity, GateActivity::class.java))
            }
            btnSettings.setOnClickListener {
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
            }
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
                            Toast.makeText(this@MainActivity, "Telefon raqam kiritildi!!", Toast.LENGTH_SHORT).show()
                        } else
                            Toast.makeText(this@MainActivity,
                                "Telefon raqam xato kiritildi!!",
                                Toast.LENGTH_SHORT).show()
                    } else
                        Toast.makeText(this@MainActivity,
                            "Telefon raqam kiritlmadi!!",
                            Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                btnDialogNo.setOnClickListener {
                    d("ishladi")
                    dialog.dismiss()
                }
            }


        }
    }
}