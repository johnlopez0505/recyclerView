package dao

import interfaceDao.InterfaceDao
import models.Hotel
import object_model.Repository

class DaoHotels private constructor(): InterfaceDao {
    companion object {
        val myDao: DaoHotels by lazy{ //lazy delega a un primer acceso
            DaoHotels() //Me creo sólo este objeto una vez.
        }
    }
    //Método que accede a la BBDD y devuelve todos los datos
    override
    fun getDataHotels(): List<Hotel> = Repository. listHotels
}

object DaoHotels2 {
    val myDao by lazy {
        getDataHotels()
    }
    private fun getDataHotels() : List<Hotel> = Repository. listHotels
}