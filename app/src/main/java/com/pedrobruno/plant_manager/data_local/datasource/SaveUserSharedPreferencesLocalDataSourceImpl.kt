package com.pedrobruno.plant_manager.data_local.datasource

import com.pedrobruno.plant_manager.data.datasource.local.SaveUserSharedPreferencesLocalDataSource
import com.pedrobruno.plant_manager.data_local.utils.LocalConstants.NAME_USER_KEY
import com.pedrobruno.plant_manager.data_local.utils.SharedPreferencesHelper

class SaveUserSharedPreferencesLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : SaveUserSharedPreferencesLocalDataSource {
    override fun saveUser(name: String?) {
        sharedPreferencesHelper.saveString(
            key = NAME_USER_KEY,
            value = name!!
        )
    }
}