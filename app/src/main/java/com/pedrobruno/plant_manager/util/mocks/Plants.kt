package com.pedrobruno.plant_manager.util.mocks

import com.pedrobruno.plant_manager.domain.model.Environment
import com.pedrobruno.plant_manager.domain.model.Plant

class Plants {
    companion object {
        val listPlants: List<Plant> = mutableListOf(
            Plant(
                id = 1,
                name = "Aningapara",
                about = "É uma espécie tropical que tem crescimento rápido e fácil manuseio.",
                water_tips = "Mantenha a terra sempre húmida sem encharcar. Regue 2 vezes na semana.",
                link_photo = "https://live.staticflickr.com/65535/51938934166_f2cb445e1c_t.jpg",
            ),
            Plant(
                id = 2,
                name = "Zamioculca",
                about = "Apesar de florescer na primavera, fica o ano todo bonita e verdinha. ",
                water_tips = "Utilize vasos com furos e pedras no fundo para facilitar a drenagem. Regue 1 vez no dia.",
                link_photo = "",
            ),
            Plant(
                id = 3,
                name = "Peperomia",
                about = "Adapta-se tanto ao sol e sombra, mas prefere ficar num cantinho fresco, sem sol direto.",
                water_tips = "\"Nos dias mais quentes borrife água nas folhas. Regue 3 vezes na semana.",
                link_photo = "https://live.staticflickr.com/65535/51937821892_8c420c7e2c_t.jpg",
            ),
            Plant(
                id = 4,
                name = "Imbé",
                about = "De médio porte que se adapta a diversas regiões, além de ser bem fácil de cultivar. Conquista cada vez mais pessoas.",
                water_tips = "Mantenha a terra sempre húmida sem encharcar. Regue 2 vezes na semana.",
                link_photo = "https://live.staticflickr.com/65535/51937821892_8c420c7e2c_t.jpg",
            ),
            Plant(
                id = 5,
                name = "Espada São Jorge",
                about = "O aroma reduz os níveis de ansiedade e seu cheiro ajudar na qualidade do sono e a produtividade durante o dia. ",
                water_tips = "Regue o solo ao redor. Regue 1 vez no dia.",
                link_photo = "jpg",
            ),
            Plant(
                id = 6,
                name = "Yucca",
                about = "São indicadas pois são fáceis de manter e cuidar. Você colocar em pequenos vasos, ou até mesmo em xícaras.",
                water_tips = "Graças à reserva de água dessas verdinhas, é sempre melhor regar pouco. Regue 1 vez na semana.",
                link_photo = "https://live.staticflickr.com/65535/51939255379_6e4bf83839_t.jpg",
            )

        )
    }
}