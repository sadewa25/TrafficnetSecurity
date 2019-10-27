package com.codedirect.trafficnetsecurity.data.prefs

interface IDataCache {

    fun setToken(token: String?)

    fun getToken(): String?

    fun clear()

}