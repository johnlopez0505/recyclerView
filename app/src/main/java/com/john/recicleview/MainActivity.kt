package com.john.recicleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.john.recicleview.databinding.ActivityMainBinding
import controller.Controller

class MainActivity : AppCompatActivity() {
    lateinit var controller : Controller
    private lateinit var bindig : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        bindig = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindig.root)

        init()
    }

    private fun init(){
        initReciclerView()
        controller = Controller(this)
        //dentro del controller crearemos el adapter y se lo pasremos al recyclerView
        controller.setAdapter()
    }

    private fun initReciclerView() {
        //La forma de pintar las view sera por medio de un lineLayou
        bindig.myRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}