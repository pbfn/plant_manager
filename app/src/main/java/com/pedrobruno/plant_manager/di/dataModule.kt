package com.pedrobruno.plant_manager.di

import com.pedrobruno.plant_manager.data.repositories.SaveUserSharedPreferencesRepositoryImpl
import com.pedrobruno.plant_manager.domain.repositories.SaveUserSharedPreferencesRepository
import org.koin.dsl.module

val dataModule = module {
    single<SaveUserSharedPreferencesRepository> { SaveUserSharedPreferencesRepositoryImpl(get()) }
}