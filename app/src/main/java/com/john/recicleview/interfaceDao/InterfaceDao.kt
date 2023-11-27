package com.john.recicleview.interfaceDao

import com.john.recicleview.models.Hotel

interface InterfaceDao {
    fun getDataHotels(): List<Hotel>
}