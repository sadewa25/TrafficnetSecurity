package com.codedirect.trafficnetsecurity.data.local.prefs

interface IDataCache {

    fun setToken(token: String?)

    fun getToken(): String?

    fun clear()

}