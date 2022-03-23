package com.pedrobruno.plant_manager.domain.repositories

import com.pedrobruno.plant_manager.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserSharedPreferencesRepository {

    fun saveUser(name: String?): Flow<User>

    fun getUser(): Flow<String>
}