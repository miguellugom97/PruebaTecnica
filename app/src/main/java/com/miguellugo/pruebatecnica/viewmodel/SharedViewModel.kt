package com.miguellugo.pruebatecnica.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel()
{
    private var _nombre = MutableLiveData("")
    val nombre : LiveData<String> = _nombre

    fun saveNombre(newNombre : String)
    {
        _nombre.value = newNombre
    }
}