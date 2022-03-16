package com.pedrobruno.plant_manager

import com.pedrobruno.plant_manager.domain.repositories.UserSharedPreferencesRepository
import com.pedrobruno.plant_manager.domain.usecase.SaveUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever


class SaveUserUseCaseTest {

    @Mock
    private lateinit var repository: UserSharedPreferencesRepository
    private lateinit var subject: SaveUserUseCase


    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        subject = SaveUserUseCase(
            userSharedPreferencesRepository = repository,
            scope = CoroutineScope(Dispatchers.IO)
        )
    }

    @Test
    fun `SAVE USER SUCCES`() = runBlocking {
        stubOnSucces()
        subject.run(
            params = SaveUserUseCase.Params(name = "Pedro")
        ).collect {
            assert(it == true)
        }
    }

    private fun stubOnSucces() {
        whenever(
            repository.saveUser(
                name = any()
            )
        ).thenAnswer {
            flowOf(true)
        }
    }
}