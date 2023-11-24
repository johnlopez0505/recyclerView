package controller

import android.content.Context
import com.john.recicleview.MainActivity
import models.Hotel

class Controller (val context: Context){
    lateinit var listHotels : MutableList<Hotel>

    init {
        initData()
    }

    private fun initData() {

    }

    fun setAdapter(){
        val myActivity = context as MainActivity
    }
}