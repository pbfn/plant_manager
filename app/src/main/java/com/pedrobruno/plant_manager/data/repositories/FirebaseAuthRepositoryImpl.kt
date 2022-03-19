package com.pedrobruno.plant_manager.data.repositories

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.pedrobruno.plant_manager.domain.model.User
import com.pedrobruno.plant_manager.domain.repositories.FirebaseAuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class FirebaseAuthRepositoryImpl() : FirebaseAuthRepository {

    override suspend fun loginGoogle(credential: AuthCredential): Flow<User?> = flow {
        var user: User? = null
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        var isNewUser = false
        firebaseAuth.signInWithCredential(credential).addOnSuccessListener { authResult ->
            val fireBaseUser = firebaseAuth.currentUser

            if (authResult.additionalUserInfo!!.isNewUser) {
                isNewUser = true
            }
            user = User(
                uid = fireBaseUser!!.uid,
                email = fireBaseUser.email,
                name = fireBaseUser.displayName,
                isNewUser = isNewUser
            )
        }
        emit(user)
    }
}