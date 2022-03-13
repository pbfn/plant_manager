package com.pedrobruno.plant_manager.data.datasource.local

interface UserSharedPreferencesLocalDataSource {
    fun saveUser(name: String?)

    fun getUser(): String
}