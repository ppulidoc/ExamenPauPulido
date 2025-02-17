package com.paudam.examenpaupulido.insert

import android.content.Context
import androidx.lifecycle.ViewModel
import com.paudam.examenpaupulido.data.Repositori
import com.paudam.practicaalumnesrepastotal.data.Producte

class InsertFragmentVM:ViewModel() {
    //funció cridar repositori i afegir productes
    fun nouProducte(context: Context,nom:String, preu: Int ) {
        var producteVM=Producte(nom, preu)
        Repositori.insertProducte(context,producteVM)
    }


}