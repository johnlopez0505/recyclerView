package adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.john.recicleview.databinding.ItemHotelBinding
import models.Hotel

class ViewHHotel (view: View,var deleteOnClick: (Int) -> Unit,var updateOnClick: (Int) -> Unit) : RecyclerView.ViewHolder (view){
    lateinit var binding: ItemHotelBinding
    init {
        binding = ItemHotelBinding.bind(view)
    }
    //método que se encarga de mapear los item por propiedad del modelo.
    fun renderize(hotel : Hotel){
        binding.txtviewName.setText(hotel. name)
        binding.txtviewCity.setText(hotel. city)
        binding.txtviewProvince.setText(hotel. province)
        binding.txtviewPhone.setText(hotel. phone)
        Glide
            .with( itemView.context)
            .load(hotel. image)
            .centerCrop()
            .into( binding.ivHotel)
        setOnClickListener(adapterPosition)
    }

    private fun setOnClickListener(position : Int) {
        binding.btnEdit.setOnClickListener {
            updateOnClick(position )
        }
        binding.btnDelete.setOnClickListener {
            deleteOnClick(position)
        }
    }

}