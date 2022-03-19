package com.pedrobruno.plant_manager.domain.usecase

import com.pedrobruno.plant_manager.domain.repositories.UserSharedPreferencesRepository
import com.pedrobruno.plant_manager.domain.usecase.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SaveUserUseCase(
    private val userSharedPreferencesRepository: UserSharedPreferencesRepository,
    scope: CoroutineScope
) : UseCase<SaveUserUseCase.Params, Boolean>(scope = scope) {


    data class Params(
        val name: String
    )

    override fun run(params: Params): Flow<Boolean> =
        userSharedPreferencesRepository.saveUser(
            name = params.name
        )
}