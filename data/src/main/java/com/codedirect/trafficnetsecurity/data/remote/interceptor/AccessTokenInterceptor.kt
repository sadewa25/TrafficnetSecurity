package com.codedirect.trafficnetsecurity.data.remote.interceptor

import com.codedirect.trafficnetsecurity.data.local.prefs.DataCache
import okhttp3.Interceptor
import okhttp3.Response

class AccessTokenInterceptor(val dataCache: DataCache) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain
                .request()
                .newBuilder()
                .apply { dataCache.getToken()?.let { addHeader("x-access-token", it) } }
                .build()
        )
    }

}