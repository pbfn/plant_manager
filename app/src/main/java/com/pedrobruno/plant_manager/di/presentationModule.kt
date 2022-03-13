package com.pedrobruno.plant_manager.di

import com.pedrobruno.plant_manager.presentation.viewmodel.IntroductionViewModel
import com.pedrobruno.plant_manager.presentation.viewmodel.ListPlantsViewModel
import com.pedrobruno.plant_manager.presentation.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { IntroductionViewModel(get()) }
    viewModel { SplashViewModel(get()) }
    viewModel { ListPlantsViewModel(get())}
}