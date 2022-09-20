package com.example.zamin.smarthouse.local

import android.content.Context
import android.content.SharedPreferences

class SharedPeriferensHelper(context: Context) {
    private  var periferens = context.getSharedPreferences("SMS",Context.MODE_PRIVATE)
    private lateinit  var editor:SharedPreferences.Editor
    fun setPhoneNumber(phone:String){
        editor = periferens.edit()
        editor.putString("phone",phone)
        editor.commit()
    }

    fun getPhoneNumber() = periferens.getString("phone","empty").toString()
}