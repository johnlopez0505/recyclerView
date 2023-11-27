package controller

import adapter.AdapterHotel
import android.content.Context
import android.widget.Toast
import com.john.recicleview.MainActivity
import com.john.recicleview.databinding.ItemHotelBinding
import dao.DaoHotels
import models.Hotel

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
        // Cargamos el Adapter que creamos.
        myActivity. binding.myRecyclerView.adapter = AdapterHotel( listHotels,{pos-> delHotel(pos)},{pos-> updateHotel(pos) })
        val h = Hotel("La Casa del Vaquero" ,
            "Abiada",
            "Cantabria" ,
            "978 65 56 65",
            "https://www.tuscasasrurales.com/imagenes/galeria/8619_g28/ico_8619.jpg")
        myActivity.binding.btnAdd.setOnClickListener {
            listHotels.add(h)

        }



    }
    fun delHotel(pos : Int){
        //Aquí habrá que crear un diáglogo para borrar el hotel
        Toast.makeText( context, "Borraremos el hotel de posición $pos",
            Toast.LENGTH_LONG).show()
        listHotels.removeAt(pos)
        adapterHotel.notifyItemRemoved(pos) //Notificamos sólo a esa posición


    }
    fun updateHotel(pos : Int){


    }
}