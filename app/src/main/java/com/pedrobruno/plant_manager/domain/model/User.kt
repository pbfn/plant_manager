package com.pedrobruno.plant_manager.domain.model

data class User(
    val uid: String,
    val email: String?,
    val name: String?,
    val isNewUser: Boolean
)