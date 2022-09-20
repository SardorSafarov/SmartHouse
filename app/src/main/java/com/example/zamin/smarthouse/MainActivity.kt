package com.example.zamin.smarthouse

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.zamin.smarthouse.databinding.ActivityMainBinding
import com.example.zamin.smarthouse.databinding.DialogChangePhoneNumberBinding
import com.example.zamin.smarthouse.utils.statusBarColor

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColor(window,"#3daafc")
        changePhoneNumber()

    }

    private fun changePhoneNumber() {
        binding.changePhoneNumber.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this,R.style.CustomAlertDialog)

            val view = LayoutInflater.from(this).inflate(R.layout.dialog_change_phone_number,null)
            val dialogView = DialogChangePhoneNumberBinding.bind(view)
            alertDialog.setView(view)


            alertDialog.show()
        }
    }
}