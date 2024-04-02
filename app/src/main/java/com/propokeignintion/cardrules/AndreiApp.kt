package com.propokeignintion.cardrules

import android.app.Application
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel
import dagger.hilt.android.HiltAndroidApp

const val ONE_SIGNAL = "e6ff5fa2-0e52-48d5-89e0-1da5ce069001"
@HiltAndroidApp
class AndreiApp: Application () {
    override fun onCreate() {
        super.onCreate()
        OneSignal.Debug.logLevel = LogLevel.VERBOSE
        OneSignal.initWithContext(this, ONE_SIGNAL)
    }
}