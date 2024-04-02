package com.propokeignintion.cardrules.domain.repository

interface SharedRepository {

    suspend fun getSound(): Boolean
    suspend fun setSound(date: Boolean)
}