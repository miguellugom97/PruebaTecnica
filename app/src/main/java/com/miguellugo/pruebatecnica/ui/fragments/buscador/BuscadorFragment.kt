package com.miguellugo.pruebatecnica.ui.fragments.buscador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguellugo.pruebatecnica.R
import com.miguellugo.pruebatecnica.databinding.FragmentBuscadorBinding
import com.miguellugo.pruebatecnica.model.Clase
import com.miguellugo.pruebatecnica.ui.fragments.catalogo.ClaseAdapter
import com.miguellugo.pruebatecnica.viewmodel.BuscadorViewModel
import com.miguellugo.pruebatecnica.viewmodel.SharedViewModel


class BuscadorFragment : Fragment(), ClaseHorizontalAdapter.OnClaseClickListener
{
    private val binding : FragmentBuscadorBinding by viewBinding()
    private val disciplinaAdapter = DisciplinaAdapter()
    private val claseHorizontalAdapter = ClaseHorizontalAdapter(this)
    private val consejoAdapter = ConsejosAdapter()
    private val sharedViewModel : SharedViewModel by activityViewModels()

    private lateinit var buscadorViewModel : BuscadorViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscador, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buscadorViewModel = ViewModelProvider(this).get(BuscadorViewModel::class.java)
        setup()
    }

    private fun setup()
    {
        initDisciplinaRecycler()
        initClaseRecycler()
        initConsejoRecycler()
    }

    private fun initDisciplinaRecycler()
    {
        val horizontalLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.disciplinaRecycleView.adapter = disciplinaAdapter
        binding.disciplinaRecycleView.layoutManager = horizontalLayoutManager
        disciplinaAdapter.setData(buscadorViewModel.getDisciplinas())
    }

    private fun initClaseRecycler()
    {
        val horizontalLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.claseRecyclerView.adapter = claseHorizontalAdapter
        binding.claseRecyclerView.layoutManager = horizontalLayoutManager
        claseHorizontalAdapter.setData(buscadorViewModel.getClases())
    }

    private fun initConsejoRecycler()
    {
        val horizontalLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.consejoRecyclerView.adapter = consejoAdapter
        binding.consejoRecyclerView.layoutManager = horizontalLayoutManager
        consejoAdapter.setData(buscadorViewModel.getConsejos())
    }

    override fun onRecyclerClick(clase: Clase)
    {
        sharedViewModel.saveClase(clase)
        sharedViewModel.saveFragment("buscador")
        Navigation.findNavController(binding.root).navigate(R.id.action_buscadorFragment_to_detalleFragment)
    }
}