package com.pedrobruno.plant_manager.di

import com.pedrobruno.plant_manager.data.datasource.local.UserSharedPreferencesLocalDataSource
import com.pedrobruno.plant_manager.data_local.datasource.UserSharedPreferencesLocalDataSourceImpl
import com.pedrobruno.plant_manager.data_local.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {
    single { SharedPreferencesHelper(androidContext()) }
    single<UserSharedPreferencesLocalDataSource> {
        UserSharedPreferencesLocalDataSourceImpl(
            get()
        )
    }
}