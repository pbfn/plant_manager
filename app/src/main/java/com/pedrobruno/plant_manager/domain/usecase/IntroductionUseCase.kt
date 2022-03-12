package com.pedrobruno.plant_manager.domain.usecase

import com.pedrobruno.plant_manager.domain.repositories.SaveUserSharedPreferencesRepository
import com.pedrobruno.plant_manager.domain.usecase.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class IntroductionUseCase(
    private val saveUserSharedPreferencesRepository: SaveUserSharedPreferencesRepository,
    scope: CoroutineScope
) : UseCase<IntroductionUseCase.Params, Boolean>(scope = scope) {


    data class Params(
        val name: String
    )

    override fun run(params: Params?): Flow<Boolean> =
        saveUserSharedPreferencesRepository.saveUser(
            name = params?.name
        )
}