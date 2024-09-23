package com.example.vingadoresapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "herois")
data class Vingadores(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val poderes: String,
    val afiliacao: String,
    val aparicao: Int,
    val ator: String
)
