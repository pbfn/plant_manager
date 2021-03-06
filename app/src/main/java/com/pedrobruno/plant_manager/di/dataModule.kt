package com.pedrobruno.plant_manager.di

import com.pedrobruno.plant_manager.data.repositories.FirebaseAuthRepositoryImpl
import com.pedrobruno.plant_manager.data.repositories.UserSharedPreferencesRepositoryImpl
import com.pedrobruno.plant_manager.domain.repositories.FirebaseAuthRepository
import com.pedrobruno.plant_manager.domain.repositories.UserSharedPreferencesRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserSharedPreferencesRepository> { UserSharedPreferencesRepositoryImpl(get()) }
    single<FirebaseAuthRepository> { FirebaseAuthRepositoryImpl() }
}