package com.codedirect.trafficnetsecurity.data.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single { androidContext().getSharedPreferences("TrafficNetPrefs", Context.MODE_PRIVATE) }

}