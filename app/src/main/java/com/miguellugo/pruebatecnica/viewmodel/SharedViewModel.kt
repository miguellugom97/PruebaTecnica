package com.miguellugo.pruebatecnica.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miguellugo.pruebatecnica.model.Clase

class SharedViewModel : ViewModel()
{
    private var _clase = MutableLiveData<Clase>()
    val clase : LiveData<Clase> = _clase

    private var _fragment = MutableLiveData("")
    val fragment : LiveData<String> = _fragment

    fun saveClase(newClase: Clase)
    {
        _clase.value = newClase
    }

    fun saveFragment(fragment: String)
    {
        _fragment.value = fragment
    }
}