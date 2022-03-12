package com.pedrobruno.plant_manager.data.datasource.local

interface SaveUserSharedPreferencesLocalDataSource {
    fun saveUser(name: String?)
}