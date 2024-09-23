package com.example.vingadoresapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Vingadores::class], version = 1, exportSchema = false)
abstract class VingadoresDatabase : RoomDatabase() {
    abstract fun vingadoresDao(): VingadoresDao
}
