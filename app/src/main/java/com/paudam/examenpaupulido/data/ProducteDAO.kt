package com.paudam.practicaalumnesrepastotal.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProducteDAO {
    //Consultes

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun afegirProducte(producte: Producte)


    //select all
    @Query("SELECT * FROM Producte ORDER BY Name DESC")
    fun obtenirProducte(): LiveData<List<Producte>>

    //select all
    @Query("DELETE FROM Producte WHERE name =:nom AND price =:preu ")
    fun borrarProducte(nom:String, preu:Int)



    //actualizar alumno por la edad
   /* @Query("UPDATE Alumne SET nom = :nombre WHERE edat = :edat")
    fun updateAlumne(nombre: String, edat: Int)*/



}