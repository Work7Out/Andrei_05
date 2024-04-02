package com.propokeignintion.cardrules.data.repository

import android.app.Application
import android.content.Context
import com.propokeignintion.cardrules.domain.repository.SharedRepository
import com.propokeignintion.cardrules.domain.utils.SHARED_DATA
import com.propokeignintion.cardrules.domain.utils.SHARED_SOUND
import com.propokeignintion.cardrules.domain.utils.URL
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SharedRepositoryImpl @Inject constructor(
    application: Application
) : SharedRepository {

    private val sharedPref = application.getSharedPreferences(SHARED_DATA, Context.MODE_PRIVATE)


    override suspend fun getSound(): Boolean {
        return sharedPref.getBoolean(SHARED_SOUND, true)
    }

    override suspend fun setSound(date: Boolean) {
        return sharedPref.edit().putBoolean(SHARED_SOUND, date).apply()
    }

    override suspend fun checkConnect(): Boolean {
        return try {
            val url = URL(URL)
            val connection = withContext(Dispatchers.IO) {
                url.openConnection()
            } as HttpURLConnection
            connection.requestMethod = "GET"

            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            val responseCode = connection.responseCode

            if (responseCode == HttpURLConnection.HTTP_OK) {

                connection.disconnect()
                true
            } else {
                connection.disconnect()
                false
            }
        } catch (e: Exception) {
            false
        }
    }
}