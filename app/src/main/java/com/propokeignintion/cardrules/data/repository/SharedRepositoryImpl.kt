package com.propokeignintion.cardrules.data.repository

import android.app.Application
import android.content.Context
import com.propokeignintion.cardrules.domain.repository.SharedRepository
import com.propokeignintion.cardrules.domain.utils.SHARED_DATA
import com.propokeignintion.cardrules.domain.utils.SHARED_SOUND
import javax.inject.Inject

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
}