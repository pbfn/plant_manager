package com.pedrobruno.plant_manager.util.mocks

import com.pedrobruno.plant_manager.domain.model.Environment

class Environments {
    companion object {
        val listEnvironments: List<Environment> = mutableListOf(
            Environment(key = "living_room", name = "Sala"),
            Environment(key = "bedroom", name = "Quarto"),
            Environment(key = "kitchen", name = "Cozinha"),
            Environment(key = "bathroom", name = "Banheiro"),
            Environment(key = "balcony", name = "Varanda"),
            Environment(key = "garage", name = "Garagem"),
        )
    }
}
