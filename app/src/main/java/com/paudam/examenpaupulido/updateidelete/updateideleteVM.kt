package com.paudam.examenpaupulido.updateidelete

import android.content.Context
import androidx.lifecycle.ViewModel
import com.paudam.examenpaupulido.data.Repositori
import com.paudam.practicaalumnesrepastotal.data.Producte

class updateideleteVM:ViewModel() {

    //funció cridar borrar
    fun deleteProducte(context: Context, nom:String, preu: Int ) {
        Repositori.deleteProducte(context,nom,preu)
    }
}