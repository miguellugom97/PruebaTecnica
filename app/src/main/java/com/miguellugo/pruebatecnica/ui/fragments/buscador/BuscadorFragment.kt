package com.miguellugo.pruebatecnica.ui.fragments.buscador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguellugo.pruebatecnica.R
import com.miguellugo.pruebatecnica.databinding.FragmentBuscadorBinding
import com.miguellugo.pruebatecnica.ui.fragments.ClaseAdapter
import com.miguellugo.pruebatecnica.viewmodel.BuscadorViewModel


class BuscadorFragment : Fragment(), ClaseAdapter.OnClaseClickListener
{
    private val binding : FragmentBuscadorBinding by viewBinding()
    private val disciplinaAdapter = DisciplinaAdapter()
    private val claseAdapter = ClaseAdapter(this)
    private val consejoAdapter = ConsejosAdapter()

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
        binding.claseRecyclerView.adapter = claseAdapter
        binding.claseRecyclerView.layoutManager = horizontalLayoutManager
        claseAdapter.setData(buscadorViewModel.getClases())
    }

    private fun initConsejoRecycler()
    {
        val horizontalLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.consejoRecyclerView.adapter = consejoAdapter
        binding.consejoRecyclerView.layoutManager = horizontalLayoutManager
        consejoAdapter.setData(buscadorViewModel.getConsejos())
    }

    override fun onRecyclerClick(nombre: String)
    {
        Toast.makeText(context, "Nombre : $nombre", Toast.LENGTH_SHORT).show()
    }
}