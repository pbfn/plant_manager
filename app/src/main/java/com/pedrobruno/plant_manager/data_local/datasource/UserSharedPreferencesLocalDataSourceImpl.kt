package com.pedrobruno.plant_manager.data_local.datasource

import com.pedrobruno.plant_manager.data.datasource.local.UserSharedPreferencesLocalDataSource
import com.pedrobruno.plant_manager.data_local.utils.LocalConstants.NAME_USER_KEY
import com.pedrobruno.plant_manager.data_local.utils.SharedPreferencesHelper
import com.pedrobruno.plant_manager.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserSharedPreferencesLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : UserSharedPreferencesLocalDataSource {
    override fun saveUser(name: String?): Flow<User> = flow {
        sharedPreferencesHelper.saveString(
            key = NAME_USER_KEY,
            value = name!!
        )
        val user = User(
            uid = "",
            email = "",
            name = name,
            isNewUser = true
        )
        emit(user)
    }

    override fun getUser(): Flow<User> = flow {
        val user =
            User(
                uid = "",
                email = "",
                name = sharedPreferencesHelper.getString(key = NAME_USER_KEY),
                isNewUser = false
            )
        emit(user)
    }
}