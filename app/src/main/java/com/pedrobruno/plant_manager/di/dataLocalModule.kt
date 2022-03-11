package com.pedrobruno.plant_manager.di

import com.pedrobruno.plant_manager.data_local.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {
    single { SharedPreferencesHelper(androidContext()) }
}