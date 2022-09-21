package com.example.zamin.smarthouse.app

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.Window
import android.widget.Toast

fun d(message:String){
    Log.d("sardor", "---->  $message  <-----")
}

fun statusBarColor(splashScreenActivity: Window, color:String) {
        splashScreenActivity.statusBarColor = Color.parseColor(color)
}
fun toast(applicationContext: Context, s: String){
    Toast.makeText(applicationContext, " $s", Toast.LENGTH_SHORT).show()
}

fun vibirator(applicationContext: Context) {
    val vibrator = applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= 26) {
        vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibrator.vibrate(500)
    }
}