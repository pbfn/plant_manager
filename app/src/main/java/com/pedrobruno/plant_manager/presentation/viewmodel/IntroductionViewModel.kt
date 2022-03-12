package com.pedrobruno.plant_manager.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedrobruno.plant_manager.domain.usecase.IntroductionUseCase

class IntroductionViewModel(
    private val introductionUseCase: IntroductionUseCase
) : ViewModel() {

    private var _user = MutableLiveData<Boolean>()
    var user: LiveData<Boolean> = _user

    fun saveUser(name: String) {
        introductionUseCase(
            params = IntroductionUseCase.Params(
                name = name
            ),
            onSuccess = {
                _user.postValue(it)
            },
            onError = {
                _user.postValue(false)
            }
        )
    }

}