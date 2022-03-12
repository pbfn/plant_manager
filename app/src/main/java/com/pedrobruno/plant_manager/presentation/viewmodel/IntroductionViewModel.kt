package com.pedrobruno.plant_manager.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.pedrobruno.plant_manager.domain.usecase.IntroductionUseCase

class IntroductionViewModel(
    private val IntroductionUseCase: IntroductionUseCase
) : ViewModel() {

}