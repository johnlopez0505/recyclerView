package interfaceDao

import models.Hotel

interface InterfaceDao {
    fun getDataHotels(): List<Hotel>
}