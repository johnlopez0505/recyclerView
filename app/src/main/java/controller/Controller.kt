package controller

import adapter.AdapterHotel
import android.content.Context
import android.widget.Toast
import com.john.recicleview.MainActivity
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
        myActivity. binding.myRecyclerView.adapter = AdapterHotel( listHotels)
    }
}