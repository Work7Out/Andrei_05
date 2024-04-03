package com.propokeignintion.cardrules.data.repository

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.propokeignintion.cardrules.domain.repository.SharedRepository
import com.propokeignintion.cardrules.domain.utils.SHARED_DATA
import com.propokeignintion.cardrules.domain.utils.SHARED_SOUND
import javax.inject.Inject

class SharedRepositoryImpl @Inject constructor(
    application: Application
) : SharedRepository {

    private val sharedPref = application.getSharedPreferences(SHARED_DATA, Context.MODE_PRIVATE)
    private val connectivityManager =
        application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override suspend fun getSound(): Boolean {
        return sharedPref.getBoolean(SHARED_SOUND, true)
    }

    override suspend fun setSound(date: Boolean) {
        return sharedPref.edit().putBoolean(SHARED_SOUND, date).apply()
    }

    @SuppressLint("ObsoleteSdkInt")
    override suspend fun checkConnect(): Boolean {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(network) ?: return false

            return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo?.isConnected ?: false
        }
    }
}