package com.codedirect.trafficnetsecurity.data.di

import android.content.Context
import com.codedirect.trafficnetsecurity.data.local.prefs.DataCache
import com.codedirect.trafficnetsecurity.data.remote.APIEndpoint
import com.codedirect.trafficnetsecurity.data.remote.interceptor.AccessTokenInterceptor
import com.codedirect.trafficnetsecurity.data.repo.SensorRepository
import com.codedirect.trafficnetsecurity.data.repo.UserRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single {
        OkHttpClient
            .Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<AccessTokenInterceptor>())
            .build()
    }

    single { HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY } }

    single { AccessTokenInterceptor(get()) }

    single {
        Retrofit
            .Builder()
            .baseUrl("http://safevision.id:6500/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single { androidContext().getSharedPreferences("TrafficNetPrefs", Context.MODE_PRIVATE) }

    single { DataCache(get()) }

    single { get<Retrofit>().create(APIEndpoint::class.java) }
    single { UserRepository(get(), get()) }
    single { SensorRepository(get()) }

}