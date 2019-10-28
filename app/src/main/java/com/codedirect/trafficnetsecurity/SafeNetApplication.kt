package com.codedirect.trafficnetsecurity

import android.app.Application
import com.codedirect.trafficnetsecurity.data.di.dataModule
import com.codedirect.trafficnetsecurity.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SafeNetApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(dataModule, uiModule))
        }
    }

}