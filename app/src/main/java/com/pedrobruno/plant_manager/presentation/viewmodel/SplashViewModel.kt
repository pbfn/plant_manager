package com.pedrobruno.plant_manager.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedrobruno.plant_manager.domain.model.User
import com.pedrobruno.plant_manager.domain.usecase.GetUserUseCase

class SplashViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private var _user = MutableLiveData<User?>()
    var user: LiveData<User?> = _user

    init {
        getUser()
    }

    private fun getUser() {
        getUserUseCase(
            params = "",
            onSuccess = {
                _user.postValue(it)
            },
            onError = {
                _user.postValue(null)
            }
        )
    }
}