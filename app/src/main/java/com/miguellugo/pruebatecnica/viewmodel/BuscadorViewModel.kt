package com.miguellugo.pruebatecnica.viewmodel

import androidx.lifecycle.ViewModel
import com.miguellugo.pruebatecnica.model.Clase
import com.miguellugo.pruebatecnica.model.Consejo
import com.miguellugo.pruebatecnica.model.Disciplina

class BuscadorViewModel : ViewModel()
{
    fun getDisciplinas(): MutableList<Disciplina> {
        return arrayListOf(
            Disciplina("Yoga", "file:///android_asset/ic_yoga.png"),
            Disciplina("Meditación", "file:///android_asset/ic_meditacion.png"),
            Disciplina("Pilates", "file:///android_asset/ic_pilates.png"),
            Disciplina("Fuerza", "file:///android_asset/ic_fuerza.png")
        )
    }

    fun getClases() : MutableList<Clase>
    {
        return arrayListOf(
            Clase("Movilidad Toracica", "Mariale Montas", "Fuerza", "file:///android_asset/movilidad_toracica.png"),
            Clase("Yoga para principiantes", "Sofía Garza", "Yoga - Principiante", "file:///android_asset/yoga_para_principiantes.png"),
            Clase("Movilidad Toracica", "Mariale Montas", "Fuerza", "file:///android_asset/movilidad_toracica3.png"),
            Clase("Movilidad Toracica", "Mariale Montas", "Fuerza", "file:///android_asset/movilidad_toracica2.png")
        )
    }

    fun getConsejos() : MutableList<Consejo>
    {
        return arrayListOf(
            Consejo("Consejo1", "Consejo1", "file:///android_asset/consejo_1.png"),
            Consejo("Alimentación Limpia", "Nutrición", "file:///android_asset/consejo_alimentacion_limpia.png"),
            Consejo("Ejercicio en Casa", "Estilo de Vida", "file:///android_asset/consejo_ejercicio_en_casa.png")
        )
    }
}