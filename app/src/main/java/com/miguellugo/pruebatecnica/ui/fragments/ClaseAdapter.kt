package com.miguellugo.pruebatecnica.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miguellugo.pruebatecnica.databinding.ItemListClasesHorizontalBinding
import com.miguellugo.pruebatecnica.databinding.ItemListClasesVerticalBinding
import com.miguellugo.pruebatecnica.model.Clase
import com.squareup.picasso.Picasso

class ClaseAdapter(private var itemClickListener : OnClaseClickListener) : RecyclerView.Adapter<ClaseAdapter.MyViewHolder>()
{
    private var claseList = emptyList<Clase>()

    interface OnClaseClickListener
    {
        fun onRecyclerClick(nombre : String)
    }
//    class MyViewHolder(private val binding : ItemListClasesHorizontalBinding) : RecyclerView.ViewHolder(binding.root)
//    {
//        fun bindView(clase: Clase)
//        {
//            Picasso.get().load(clase.imagen).into(binding.claseImageView)
//            binding.nombreClaseTextView.text = clase.nombre
//            binding.instructorClaseTextView.text = clase.instructor
//            binding.disciplinaTextView.text = clase.disciplina
//        }
//    }

    class MyViewHolder(val binding : ItemListClasesVerticalBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bindView(clase: Clase)
        {
            Picasso.get().load(clase.imagen).fit().centerCrop().into(binding.claseImageView)
            binding.nombreClaseTextView.text = clase.nombre
            binding.instructorClaseTextView.text = clase.instructor
            binding.disciplinaTextView.text = clase.disciplina
        }
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        return MyViewHolder(ItemListClasesHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemListClasesVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = claseList[position]
        holder.bindView(currentItem)
        holder.binding.root.setOnClickListener()
        {
            itemClickListener.onRecyclerClick(currentItem.nombre)
        }
    }

    override fun getItemCount(): Int {
        return claseList.size
    }

    fun setData(clase: List<Clase>)
    {
        this.claseList = clase
        notifyDataSetChanged()
    }
}