package com.pedrobruno.plant_manager.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.AuthCredential
import com.pedrobruno.plant_manager.domain.model.User
import com.pedrobruno.plant_manager.domain.usecase.AuthUserFirebaseUseCase

class AuthGoogleViewModel(
    private val authUserFirebaseUseCase: AuthUserFirebaseUseCase
) : ViewModel() {

    private var _user = MutableLiveData<User>()
    var user: LiveData<User> = _user


    fun loginWithGoogle(credential: AuthCredential){
        authUserFirebaseUseCase(
            params = AuthUserFirebaseUseCase.Params(
                googleAuthCredential = credential
            ),
            onSuccess = {
                if (it != null) {
                    Log.d("AuthGoogleViewModel","email:${it.email}")
                    _user.postValue(it)
                }
            }
        )
    }


}