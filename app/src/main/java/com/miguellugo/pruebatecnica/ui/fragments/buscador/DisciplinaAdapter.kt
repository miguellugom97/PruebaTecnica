package com.miguellugo.pruebatecnica.ui.fragments.buscador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miguellugo.pruebatecnica.databinding.ItemListDisciplinasBinding
import com.miguellugo.pruebatecnica.model.Disciplina
import com.squareup.picasso.Picasso

class DisciplinaAdapter : RecyclerView.Adapter<DisciplinaAdapter.MyViewHolder>()
{
    private var disciplinaList = emptyList<Disciplina>()
    class MyViewHolder(private val binding : ItemListDisciplinasBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bindView(disciplina: Disciplina)
        {
            binding.nombreTextView.text = disciplina.nombre
            Picasso.get().load(disciplina.imagen).into(binding.disciplinaImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemListDisciplinasBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = disciplinaList[position]
        holder.bindView(currentItem)
    }

    override fun getItemCount(): Int {
        return disciplinaList.size
    }

    fun setData(disciplina: List<Disciplina>)
    {
        this.disciplinaList = disciplina
        notifyDataSetChanged()
    }
}