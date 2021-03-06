package com.pedrobruno.plant_manager.domain.usecase

import com.pedrobruno.plant_manager.domain.model.User
import com.pedrobruno.plant_manager.domain.repositories.UserSharedPreferencesRepository
import com.pedrobruno.plant_manager.domain.usecase.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetUserUseCase(
    private val userSharedPreferencesRepository: UserSharedPreferencesRepository,
    scope: CoroutineScope
) : UseCase<String, User>(scope = scope) {


    override fun run(params: String): Flow<User> {
        return userSharedPreferencesRepository.getUser()
    }

}