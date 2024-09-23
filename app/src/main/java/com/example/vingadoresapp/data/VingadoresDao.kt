package com.example.vingadoresapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface VingadoresDao {
    @Query("SELECT * FROM herois")
    fun getHerois(): Flow<List<Vingadores>>

    @Query("SELECT * FROM herois WHERE id = :id")
    fun getHeroiById(id: Int): Flow<Vingadores>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroi(vingadores: Vingadores)

    @Delete
    suspend fun deleteHeroi(vingadores: Vingadores)
}
