package com.codedirect.trafficnetsecurity.data.prefs

import android.content.SharedPreferences
import org.koin.core.KoinComponent

class DataCache(private val mPrefs: SharedPreferences) : IDataCache, KoinComponent {

    companion object {

        private const val KEY_TOKEN = "TOKEN_API"

    }

    override fun setToken(token: String?) {
        mPrefs.edit().putString(KEY_TOKEN, token).apply()
    }

    override fun getToken(): String? = mPrefs.getString(KEY_TOKEN, null)

    override fun clear() {
        mPrefs.edit().clear().apply()
    }

}