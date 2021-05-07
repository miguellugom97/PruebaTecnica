package com.miguellugo.pruebatecnica.ui.fragments.detalle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.miguellugo.pruebatecnica.R
import com.miguellugo.pruebatecnica.databinding.FragmentDetalleBinding
import com.miguellugo.pruebatecnica.model.Clase
import com.miguellugo.pruebatecnica.viewmodel.SharedViewModel
import com.squareup.picasso.Picasso

class DetalleFragment : Fragment()
{
    private val binding : FragmentDetalleBinding by viewBinding()
    private val sharedViewModel : SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup()
    {
        getClase()
        binding.backImageView.setOnClickListener()
        {
            sharedViewModel.fragment.observe(viewLifecycleOwner, {
                backNavigation(it)
            })
        }
    }

    private fun backNavigation(fragment : String)
    {
        if (fragment == "buscador")
        {
            Navigation.findNavController(binding.root).navigate(R.id.action_detalleFragment_to_buscadorFragment)
        }else {
            Navigation.findNavController(binding.root).navigate(R.id.action_detalleFragment_to_catalogoFragment)
        }
    }

    private fun getClase()
    {
        sharedViewModel.clase.observe(viewLifecycleOwner, {
            val nombre = it
            showClase(nombre)
        })
    }

    private fun showClase(clase : Clase)
    {
        val (nombre,instructor,disciplina,imagen) = clase
        binding.nombreTextview.text = nombre
        binding.instructorTextview.text = instructor
        binding.disciplinaTextview.text = disciplina
        Picasso.get().load(imagen).fit().centerCrop().into(binding.claseImageView)
    }
}