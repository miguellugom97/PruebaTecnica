package com.miguellugo.pruebatecnica.ui.fragments.buscador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miguellugo.pruebatecnica.databinding.ItemListConsejosHorizontalBinding
import com.miguellugo.pruebatecnica.model.Consejo
import com.squareup.picasso.Picasso

class ConsejosAdapter : RecyclerView.Adapter<ConsejosAdapter.MyViewHolder>()
{
    private var consejosList = emptyList<Consejo>()
    class MyViewHolder(private val binding : ItemListConsejosHorizontalBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bindView(consejo: Consejo)
        {
            Picasso.get().load(consejo.imagen).fit().centerCrop().into(binding.consejoImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemListConsejosHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = consejosList[position]
        holder.bindView(currentItem)
    }

    override fun getItemCount(): Int
    {
        return consejosList.size
    }

    fun setData(consejo : List<Consejo>)
    {
        this.consejosList = consejo
        notifyDataSetChanged()
    }
}