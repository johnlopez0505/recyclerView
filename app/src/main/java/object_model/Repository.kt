package object_model

import models.Hotel

object Repository {
    val listHotels : List<Hotel> = listOf(
        Hotel(
            "Antiguo Palacio de Atienza" , "Atienza", "Guadalajara" ,
            "975 45 54 45"
        ),
        Hotel(
            "La Casa del Vaquero" , "Abiada", "Cantabria" ,
            "978 65 56 65"
        ),
        Hotel(
            "La Casa de juan" , "jaen", "jaen" ,
            "645 65 56 56"
        ))
}