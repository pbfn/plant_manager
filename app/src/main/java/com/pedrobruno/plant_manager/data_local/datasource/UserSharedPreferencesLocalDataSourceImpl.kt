package com.pedrobruno.plant_manager.data_local.datasource

import com.pedrobruno.plant_manager.data.datasource.local.UserSharedPreferencesLocalDataSource
import com.pedrobruno.plant_manager.data_local.utils.LocalConstants.NAME_USER_KEY
import com.pedrobruno.plant_manager.data_local.utils.SharedPreferencesHelper

class UserSharedPreferencesLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : UserSharedPreferencesLocalDataSource {
    override fun saveUser(name: String?) {
        sharedPreferencesHelper.saveString(
            key = NAME_USER_KEY,
            value = name!!
        )
    }

    override fun getUser(): String {
        return sharedPreferencesHelper.getString(key = NAME_USER_KEY)
    }
}