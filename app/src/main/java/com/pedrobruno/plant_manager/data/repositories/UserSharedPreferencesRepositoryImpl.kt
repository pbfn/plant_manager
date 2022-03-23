package com.pedrobruno.plant_manager.data.repositories

import com.pedrobruno.plant_manager.data.datasource.local.UserSharedPreferencesLocalDataSource
import com.pedrobruno.plant_manager.domain.model.User
import com.pedrobruno.plant_manager.domain.repositories.UserSharedPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class UserSharedPreferencesRepositoryImpl(
    private val userSharedPreferencesLocalDataSource: UserSharedPreferencesLocalDataSource
) : UserSharedPreferencesRepository {
    override fun saveUser(name: String?): Flow<User> = flow {
        userSharedPreferencesLocalDataSource.saveUser(name = name).collect { user ->
            emit(user)
        }

    }

    override fun getUser(): Flow<String> = flow {
        val nameUser = userSharedPreferencesLocalDataSource.getUser()
        emit(nameUser)
    }
}