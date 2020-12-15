package com.manhee.newsapp_2020_mk

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.Constraints.TAG

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        // #1. Manifest-declared Broadcast-receiver
        var stringAction = intent.action
        Toast.makeText(context, stringAction, Toast.LENGTH_SHORT).show()

        var timeZone = intent.getStringExtra("time-zone")
        Log.d(TAG, "onReceive: " + timeZone)


//        // #2. Context-declared Broadcast-receiver
//        // i) Airplane Mode
//        // ii) Power-Connected:
//        // 'state' is the boolean-extra attached... (according to ANDROID-DOCUMENTATION)
////        var isOn = intent.getBooleanExtra("state", false)
//        Log.d(TAG, "onReceive: airplane mode is on " + intent.getBooleanExtra("state", false))


    }
}
