package com.pedrobruno.plant_manager.data.repositories

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.pedrobruno.plant_manager.domain.model.User
import com.pedrobruno.plant_manager.domain.repositories.FirebaseAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirebaseAuthRepositoryImpl(private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()) :
    FirebaseAuthRepository {

    override fun loginGoogle(credential: AuthCredential): Flow<User?> {
        var user: User? = null
        var isNewUser = false
        return channelFlow {
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
            }.addOnCompleteListener {
                launch {
                    send(user)
                }
            }
            awaitClose()
        }


    }
}