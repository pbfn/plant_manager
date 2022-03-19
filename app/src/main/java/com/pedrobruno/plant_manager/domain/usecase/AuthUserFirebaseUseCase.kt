package com.pedrobruno.plant_manager.domain.usecase

import com.google.firebase.auth.AuthCredential
import com.pedrobruno.plant_manager.domain.model.User
import com.pedrobruno.plant_manager.domain.repositories.FirebaseAuthRepository
import com.pedrobruno.plant_manager.domain.usecase.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthUserFirebaseUseCase(
    private val authFirebaseRepository: FirebaseAuthRepository,
    scope: CoroutineScope
) : UseCase<AuthUserFirebaseUseCase.Params, User>(scope = scope) {


    data class Params(
        val googleAuthCredential: AuthCredential
    )

    override fun run(params: Params): Flow<User> = flow {
        authFirebaseRepository.loginGoogle(params.googleAuthCredential)
    }

}