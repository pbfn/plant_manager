package com.pedrobruno.plant_manager.domain.repositories

import com.google.firebase.auth.AuthCredential
import com.pedrobruno.plant_manager.domain.model.User
import kotlinx.coroutines.flow.Flow

interface FirebaseAuthRepository {

    suspend fun loginGoogle(credential: AuthCredential): Flow<User?>

}