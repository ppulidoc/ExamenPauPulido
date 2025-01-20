package com.paudam.examenpaupulido.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.paudam.practicaalumnesrepastotal.data.Producte
import com.paudam.practicaalumnesrepastotal.data.dataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repositori {
    companion object {
        var repositori_database: dataBase? = null

        var productes: LiveData<List<Producte>>? = null



        //funció per a inicialitzar la BD

        fun initializeDB(context: Context): dataBase {
            return dataBase.getDatabase(context)
        }

        //TODO:funcio qyue cridi a l'insert

        fun insertProducte(context: Context, producte: Producte) {

            //Connectar la BD
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                repositori_database!!.ProducteDAO().afegirProducte(producte)
            }
        }



        //TODO:funcio qyue cridi al delete

        fun deleteProducte(context: Context, nom:String, preu:Int){

            //Connectar la BD
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                repositori_database!!.ProducteDAO().borrarProducte(nom,preu)
            }
        }




        //TODO:funcio que torni la select

        fun obtenirProductes(context: Context): LiveData<List<Producte>>? {
            //Connectar la BD
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                productes = repositori_database!!.ProducteDAO().obtenirProducte()
            }

            return productes

        }



/*
        fun actualizarAlumne(context: Context,nombre: String, edat: Int) {
            //Connectar la BD
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                repositori_database!!.alumneDao().updateAlumne(nombre,edat)
            }

        }*/









    }
}