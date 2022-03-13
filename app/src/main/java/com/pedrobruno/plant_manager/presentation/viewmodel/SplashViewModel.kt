package com.pedrobruno.plant_manager.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedrobruno.plant_manager.domain.usecase.SplashUseCase

class SplashViewModel(
    private val splashUseCase: SplashUseCase
) : ViewModel() {

    private var _user = MutableLiveData<String>()
    var user: LiveData<String> = _user

    init {
        getUser()
    }

    private fun getUser() {
        splashUseCase(
            params = "",
            onSuccess = {
                _user.postValue(it)
            },
            onError = {
                _user.postValue("")
            }
        )
    }
}