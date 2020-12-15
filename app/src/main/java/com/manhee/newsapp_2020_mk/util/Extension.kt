package com.manhee.newsapp_2020_mk.util

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.manhee.newsapp_2020_mk.BuildConfig
import java.text.SimpleDateFormat
import java.util.*

// logd
fun Activity.logd(message: String){
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}

// toast
fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
