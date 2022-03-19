package com.pedrobruno.plant_manager.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.AuthCredential
import com.pedrobruno.plant_manager.domain.usecase.AuthUserFirebaseUseCase

class AuthGoogleViewModel(
    private val authUserFirebaseUseCase: AuthUserFirebaseUseCase
) : ViewModel() {



    fun loginWithGoogle(credential: AuthCredential){
        authUserFirebaseUseCase(
            params = AuthUserFirebaseUseCase.Params(
                googleAuthCredential = credential
            ),
            onSuccess = {
                Log.d("AuthGoogleViewModel","email:${it.email}")
            }
        )
    }


}