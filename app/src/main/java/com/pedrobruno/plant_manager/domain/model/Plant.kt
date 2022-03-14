package com.pedrobruno.plant_manager.domain.model


data class Plant(
    val id: Int,
    val name: String,
    val about: String,
    val water_tips: String,
    val link_photo: String,
    val environments: List<Environment>? = null,
    val frequency: List<String>? = null
)
