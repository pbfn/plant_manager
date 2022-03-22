package com.pedrobruno.plant_manager.di

import com.pedrobruno.plant_manager.domain.usecase.AuthUserFirebaseUseCase
import com.pedrobruno.plant_manager.domain.usecase.SaveUserUseCase
import com.pedrobruno.plant_manager.domain.usecase.GetUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    single {
        CoroutineScope(Dispatchers.IO)
    }
    factory { SaveUserUseCase(get(), get()) }
    factory { GetUserUseCase(get(), get()) }
    factory { AuthUserFirebaseUseCase(get(), get()) }
}