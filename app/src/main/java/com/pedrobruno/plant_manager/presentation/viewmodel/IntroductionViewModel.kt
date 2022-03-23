package com.pedrobruno.plant_manager.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedrobruno.plant_manager.domain.model.User
import com.pedrobruno.plant_manager.domain.usecase.SaveUserUseCase

class IntroductionViewModel(
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    private var _user = MutableLiveData<User?>()
    var user: LiveData<User?> = _user

    fun saveUser(name: String) {
        saveUserUseCase(
            params = SaveUserUseCase.Params(
                name = name
            ),
            onSuccess = {
                _user.postValue(it)
            },
            onError = {
                _user.postValue(null)
            }
        )
    }

}