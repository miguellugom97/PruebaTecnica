package com.miguellugo.pruebatecnica.ui.fragments.catalogo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguellugo.pruebatecnica.R
import com.miguellugo.pruebatecnica.databinding.FragmentCatalogoBinding
import com.miguellugo.pruebatecnica.model.Clase
import com.miguellugo.pruebatecnica.viewmodel.BuscadorViewModel
import com.miguellugo.pruebatecnica.viewmodel.SharedViewModel

class CatalogoFragment : Fragment(), ClaseAdapter.OnClaseClickListener
{
    private val binding : FragmentCatalogoBinding by viewBinding()
    private val claseAdapter = ClaseAdapter(this)
    private lateinit var buscadorViewModel: BuscadorViewModel
    private val sharedViewModel : SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalogo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buscadorViewModel = ViewModelProvider(this).get(BuscadorViewModel::class.java)
        setup()
    }

    private fun setup() {
        initClaseRecycler()
        initSpinner()
    }

    private fun initClaseRecycler()
    {
        binding.claseRecyclerView.adapter = claseAdapter
        binding.claseRecyclerView.layoutManager = LinearLayoutManager(context)
        claseAdapter.setData(buscadorViewModel.getClases())
    }

    private fun initSpinner()
    {
        val strings = resources.getStringArray(R.array.ordenar_por)
        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, strings)
        binding.spinner.adapter = arrayAdapter
    }

    override fun onRecyclerClick(clase: Clase)
    {
        sharedViewModel.saveClase(clase)
        sharedViewModel.saveFragment("catalogo")
        Navigation.findNavController(binding.root).navigate(R.id.action_catalogoFragment_to_detalleFragment)
    }
}