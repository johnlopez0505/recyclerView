package com.john.recicleview.controller

import com.john.recicleview.adapter.AdapterHotel
import android.content.Context
import android.widget.Toast
import com.john.recicleview.MainActivity
import com.john.recicleview.databinding.ItemHotelBinding
import com.john.recicleview.dao.DaoHotels
import com.john.recicleview.models.Hotel

class Controller ( val context : Context){
    lateinit var listHotels : MutableList<Hotel> //lista de objetos
    init {
        initData()
    }
    fun initData(){
        // listHotels = DaoHotels2.myDao.toMutableList()
        listHotels = DaoHotels. myDao.getDataHotels(). toMutableList() //llamamos al singleton.

    }
    fun loggOut() {
        Toast.makeText( context, "He mostrado los datos en pantalla", Toast. LENGTH_LONG).show()
        listHotels.forEach{
            println (it)
        }
    }

    // Cargamos nuestro AdapterHotgel al adapter del RecyclerView
    fun setAdapter() {
        val myActivity = context as MainActivity
        myActivity.binding.myRecyclerView.adapter = AdapterHotel(listHotels,
            { pos -> delHotel(pos) }, { pos -> updateHotel(pos) })

        val h = Hotel(
            "El condestable",
            "Jaén",
            "Jaén",
            "978 65 56 65",
            "https://upload.wikimedia.org/wikipedia/commons/4/4a/Ja%C3%A9n_-_Hotel_Condestable_Iranzo_K02.jpg"
        )
        myActivity.binding.btnAdd.setOnClickListener {
            Toast.makeText(context, "Creado un nuevo hotel ", Toast.LENGTH_LONG).show()
            listHotels.add(h)
            myActivity.binding.myRecyclerView.adapter?.notifyItemInserted(listHotels.size)
        }
    }

    fun delHotel(pos: Int) {
        val myActivity = context as MainActivity
        val adapter = myActivity.binding.myRecyclerView.adapter as AdapterHotel

        Toast.makeText(context, "Borraremos el hotel de posición $pos", Toast.LENGTH_LONG).show()

        listHotels.removeAt(pos)
        adapter.notifyItemRemoved(pos)
        adapter.notifyDataSetChanged()
    }


    fun updateHotel(pos: Int) {
        val myActivity = context as MainActivity
        val adapter = myActivity.binding.myRecyclerView.adapter as AdapterHotel

        val hotelToUpdate = listHotels[pos]

        // Implementa la lógica para la actualización aquí
        val updatedHotel = Hotel(
            "Infanta Cristina",  // Puedes solicitar al usuario que ingrese un nuevo nombre
            hotelToUpdate.city,
            hotelToUpdate.province,
            hotelToUpdate.phone,
            "https://media-cdn.tripadvisor.com/media/photo-s/02/ed/7f/15/hotel-infanta-cristina.jpg"
        )

        // Actualiza el hotel en la lista
        listHotels[pos] = updatedHotel

        // Notifica al adaptador sobre el cambio
        adapter.notifyItemChanged(pos)
    }



}