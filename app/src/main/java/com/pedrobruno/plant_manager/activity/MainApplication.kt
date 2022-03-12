package com.pedrobruno.plant_manager.activity

import android.app.Application
import com.pedrobruno.plant_manager.di.dataLocalModule
import com.pedrobruno.plant_manager.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                dataLocalModule,
                domainModule
            ).androidContext(applicationContext)
        }
    }
}