package com.paudam.examenpaupulido.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.paudam.examenpaupulido.data.Repositori
import com.paudam.practicaalumnesrepastotal.data.Producte

class HomeFragmentVM: ViewModel() {
    private var _llistat_productes: LiveData<List<Producte>>?=null
    val llistat_productes: LiveData<List<Producte>>?
        get()=_llistat_productes


    //funció obtenirAlumnes

    fun llistar_productes(context: Context) {
        _llistat_productes = Repositori.obtenirProductes(context)
    }
}