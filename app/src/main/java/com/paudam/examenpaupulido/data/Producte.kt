package com.paudam.practicaalumnesrepastotal.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Producte")
data class Producte(
    @ColumnInfo(name = "Name")
    var nom: String,
    @ColumnInfo(name = "Price")
    var preu: Int,
){
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}
