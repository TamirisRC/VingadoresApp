package com.example.vingadoresapp.data

import android.content.Context
import androidx.room.Room

class AppContainer(context: Context) {
    private val database: VingadoresDatabase by lazy {
        Room.databaseBuilder(context, VingadoresDatabase::class.java, "db_vingadores").build()
    }

    val vingadoresRepository: VingadoresRepository by lazy {
        VingadoresRepository(database.vingadoresDao())
    }
}