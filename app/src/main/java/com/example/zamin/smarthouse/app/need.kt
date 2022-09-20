package com.example.zamin.smarthouse.app

import android.graphics.Color
import android.util.Log
import android.view.Window

fun d(message:String){
    Log.d("sardor", "---->  $message  <-----")
}

fun statusBarColor(splashScreenActivity: Window, color:String) {
        splashScreenActivity.statusBarColor = Color.parseColor(color)
}