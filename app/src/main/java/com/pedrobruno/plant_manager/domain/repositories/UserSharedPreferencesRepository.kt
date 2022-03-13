package com.pedrobruno.plant_manager.domain.repositories

import kotlinx.coroutines.flow.Flow

interface UserSharedPreferencesRepository {

    fun saveUser(name: String?): Flow<Boolean>

    fun getUser(): Flow<String>
}