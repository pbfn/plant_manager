package com.pedrobruno.plant_manager.data.datasource.local

import com.pedrobruno.plant_manager.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserSharedPreferencesLocalDataSource {
    fun saveUser(name: String?): Flow<User>

    fun getUser(): Flow<User>
}