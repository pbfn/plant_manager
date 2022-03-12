package com.pedrobruno.plant_manager.domain.repositories

import kotlinx.coroutines.flow.Flow

interface SaveUserSharedPreferencesRepository {

    fun saveUser(name: String?): Flow<Boolean>
}