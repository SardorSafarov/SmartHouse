package com.example.zamin.smarthouse.utils

import android.graphics.Color
import android.util.Log
import android.view.Window
import com.example.zamin.smarthouse.splashScreen.SplashScreenActivity

fun d(message:String){
    Log.d("sardor", "---->  $message  <-----")
}

fun statusBarColor(splashScreenActivity: Window, color:String) {
        splashScreenActivity.statusBarColor = Color.parseColor(color)
}