package com.pedrobruno.plant_manager.data.repositories

import com.pedrobruno.plant_manager.data.datasource.local.SaveUserSharedPreferencesLocalDataSource
import com.pedrobruno.plant_manager.domain.repositories.SaveUserSharedPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveUserSharedPreferencesRepositoryImpl(
    private val saveUserSharedPreferencesLocalDataSource: SaveUserSharedPreferencesLocalDataSource
) : SaveUserSharedPreferencesRepository {
    override fun saveUser(name: String?): Flow<Boolean> = flow {
        saveUserSharedPreferencesLocalDataSource.saveUser(name = name)
        emit(true)
    }
}