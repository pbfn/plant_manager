package com.pedrobruno.plant_manager.di

import com.pedrobruno.plant_manager.domain.usecase.IntroductionUseCase
import com.pedrobruno.plant_manager.domain.usecase.SplashUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    single {
        CoroutineScope(Dispatchers.IO)
    }
    factory { IntroductionUseCase(get(), get()) }
    factory { SplashUseCase(get(), get()) }
}